package application;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.ProductConsume")
public class ProductConsume {
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue(3);
        // 3个消费者
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    while (true) {
                        TimeUnit.MICROSECONDS.sleep(200);
                        Message take = messageQueue.take();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "消费者" + i).start();
        }
        Thread product = new Thread(() -> {
            while (true) {
                try {
                    double number = Math.random() * 100;
                    messageQueue.put(new Message((int) number, "" + number));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "生产者");
        product.start();
    }
}

@Slf4j(topic = "c.MessageQueue")
class MessageQueue {
    private LinkedList<Message> list = new LinkedList<>();
    // 队列容量
    private int capcity;

    public MessageQueue(int capcity) {
        this.capcity = capcity;
    }

    // put 和 get 总有一个会满足
    public void put(Message message) throws InterruptedException {
        synchronized (list) {
            while (list.size() == capcity) {
                list.wait();
            }
            // 将消息加入队列尾部
            list.addLast(message);
            log.debug("生产者{} 生产{}", Thread.currentThread().getName(), message);
            list.notifyAll();
        }
    }

    // 存入消息。线程通信之间 id 和重要，通过 id 识别线程？
    public Message take() throws InterruptedException {
        synchronized (list) {
            while (list.isEmpty()) {
                list.wait();
            }
            // 从队列头部获取消息
            Message message = list.removeFirst();
            log.debug("消费者{} 消费{}", Thread.currentThread(), message);
            list.notifyAll();
            return message;
        }
    }
}

@Getter
class Message {
    private int id;
    private Object value;

    public Message(int id, Object value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}