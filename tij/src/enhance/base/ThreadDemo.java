package enhance.base;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition notFull = lock.newCondition(); // 消费者阻塞队列
        Condition notEmpty = lock.newCondition(); // 生产者阻塞队列
        Queue<String> queue = new ArrayDeque<String>();
        int queueSize = 10;
        // 消费者
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    while (0 == queue.size()) {
                        notFull.await(); // 不能消费，消费者要阻塞。
                    }
                    // 消费一个元素，可以叫生产者过来生产了
                    System.out.println(queue.poll());
                    notEmpty.signalAll();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }finally {
                    lock.unlock();
                }
            }
        }).start();
        // 生产者
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    while (queueSize == queue.size()) {
                        notEmpty.await(); // 满了,把生产者线程放到生产者阻塞队列里
                    }
                    // 生产一个元素
                    queue.add("ele");
                    notFull.signalAll(); // 可以唤醒消费者消费了
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }finally {
                    lock.unlock();
                }
            }
        }).start();

    }
}
