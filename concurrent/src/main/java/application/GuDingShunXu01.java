package application;

import lombok.extern.slf4j.Slf4j;

// 先打印2，在打印1
@Slf4j(topic = "c.GuDingShunXu01")
public class GuDingShunXu01 {
    static Object lock = new Object();
    // 表示 t2 是否运行过
    static boolean t2Run = false;

    public static void main(String[] args) {
        Thread th1 = new Thread(() -> {
            synchronized (lock) {
                while (!t2Run) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            log.debug("1");
        }, "th1");
        Thread th2 = new Thread(() -> {
            synchronized (lock) {
                log.debug("2");
                t2Run = true;
                lock.notifyAll();
            }
        }, "th2");
        th2.start();
        th1.start();
    }
}
