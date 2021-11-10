package application;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

public class Balking {
    public static void main(String[] args) throws InterruptedException {
        MyBalking myBalking = new MyBalking();
        myBalking.start();
        myBalking.start();
        TimeUnit.SECONDS.sleep(5);
        myBalking.stop();

    }
}

@Slf4j(topic = "c.MyBalking")
class MyBalking {
    private Thread monitor;
    private boolean first = true;

    public void stop() {
        monitor.interrupt();
    }

    // 执行监控
    public void start() {
        synchronized (this) {
            if (!first) {
                log.debug("已经开启过了！！");
                return;
            }
            first = false;
        }
        monitor = new Thread(() -> {
            Thread current = Thread.currentThread();

            while (true) {
                if (current.isInterrupted()) {
                    log.debug("over!");
                    return;
                }
                try {
                    TimeUnit.SECONDS.sleep(2);
                    log.debug("开始监控！！");
                } catch (InterruptedException e) {
                    current.interrupt();
                    log.debug("处理杂事");
                    e.printStackTrace();
                }
            }
        });
        monitor.start();
    }


}