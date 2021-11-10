package application;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.GuardedFutures")
public class GuardedFutures {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            new Thread(new People(), "收信" + i).start();
        }
        TimeUnit.SECONDS.sleep(2);
        for (Integer id : Mailboxes.getIds()) {
            new Thread(new PostMan(id, "内容" + id)).start();
        }
    }
}

@Slf4j(topic = "c.People")
class People implements Runnable {

    @Override
    public void run() {
        GuardedObject2 guardedObject = Mailboxes.createGuardedObject();
        log.debug("开始收信id:{}", guardedObject.getId());
        Object mail = guardedObject.get(5000);
        log.debug("收到信id:{},内容{}", guardedObject.getId(), mail);

    }
}

@Slf4j(topic = "c.PostMan")
class PostMan implements Runnable {
    private int id;
    private String mail;

    public PostMan(int id, String mail) {
        this.id = id;
        this.mail = mail;
    }

    @Override
    public void run() {
        GuardedObject2 guardedObject = Mailboxes.getGuardedObjectById(id);
        log.debug("送信id：{}，内容{}", id, mail);
        guardedObject.complete(mail);

    }
}

class Mailboxes {
    private static Map<Integer, GuardedObject2> boxes = new ConcurrentHashMap<>();
    private static int id = 1;

    public static synchronized int generateId() {
        return id++;
    }

    // 创建对象 放入map
    public static GuardedObject2 createGuardedObject() {
        GuardedObject2 go = new GuardedObject2(generateId());
        boxes.put(go.getId(), go);
        return go;
    }

    public static Set<Integer> getIds() {
        return boxes.keySet();
    }

    public static GuardedObject2 getGuardedObjectById(int id) {
        // 需要移除，避免太多对象导致 OOM
        return boxes.remove(id);
    }

}

class GuardedObject2 {
    private int id;

    public int getId() {
        return this.id;
    }

    public GuardedObject2(int id) {
        this.id = id;
    }

    private Object response;

    // 限时等待
    public Object get(long timeout) {
        synchronized (this) {
            long start = System.currentTimeMillis();
            long passedTime = 0;
            try {
                while (response == null) {
                    if (passedTime >= timeout) break;
                    this.wait(timeout - passedTime);
                    passedTime = System.currentTimeMillis() - start;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return response;
    }

    public void complete(Object response) {
        synchronized (this) {
            this.response = response;
            this.notifyAll();
        }
    }
}
