package interrupt;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.InterruptNormal")
public class InterruptNormal {
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        // 线程被打断后就不在运行
        Thread th1 = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) ;
        });

        th1.start();
        TimeUnit.SECONDS.sleep(5);
        th1.interrupt();
        log.debug(String.valueOf(th1.isInterrupted()));
    }

}
