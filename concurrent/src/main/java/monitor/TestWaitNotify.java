package monitor;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.TestWaitNotify")
public class TestWaitNotify {
    final static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread th1 = new Thread(() -> {
            try {
                synchronized (obj) {
                    log.debug("执行");
                    obj.wait();
                    log.debug("其他代码");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        Thread th2 = new Thread(() -> {
            try {
                synchronized (obj) {
                    log.debug("执行");
                    obj.wait();
                    log.debug("其他代码");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2");
        th1.start();
        th2.start();
        TimeUnit.SECONDS.sleep(1);
        log.debug("唤醒 obj 上其他线程");
        synchronized (obj) {
            obj.notifyAll();
        }
    }
}
