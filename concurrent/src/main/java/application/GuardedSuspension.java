package application;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.GuardedSuspension")
public class GuardedSuspension {

    public static void main(String[] args) {
        // 两个线程用同一个对象进行交互。
        GuardedObject guardedObject = new GuardedObject();
        Thread th1 = new Thread(() -> {
            log.debug("等待结果");
            Object response = guardedObject.get(2000);// 等待结果
            log.debug("结果是{}", response);
        }, "th1");
        Thread th2 = new Thread(() -> {
            log.debug("执行下载");
            try {
                TimeUnit.SECONDS.sleep(1);
                guardedObject.complete(null);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "th2");
        th1.start();
        th2.start();
    }
}

class GuardedObject {
    // 等待的数据
    private Object response;

    // timeout 总共等几秒
    public Object get(long timeout) {
        synchronized (this) {
            // 开始时间
            long begin = System.currentTimeMillis();
            // 经历的时间
            long passedTime = 0;
            try {
                // 没有结果就一直等待；while 防止虚假唤醒。
                while (response == null) {
                    // 经历的时间超过了最大等待时间
                    if (passedTime >= timeout) break;
                    // 等了 passedTime 秒了，再等 timeout - passedTime 就可以了
                    this.wait(timeout - passedTime);
                    passedTime = System.currentTimeMillis() - begin;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return response;
        }
    }

    // 产生结果
    public void complete(Object response) {
        synchronized (this) {
            this.response = response;
            this.notifyAll();
        }
    }
}

class DownLoad {
    public static final List<String> downLoad() {
        HttpURLConnection conn = null;
        ArrayList<String> lines = new ArrayList<>();
        try {
            conn = (HttpURLConnection) new URL("https://www.baidu.com/").openConnection();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}