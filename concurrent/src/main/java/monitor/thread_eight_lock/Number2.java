package monitor.thread_eight_lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.Number2")
public class Number2 {
    public synchronized void a() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        log.debug("1");
    }

    public synchronized void b() {
        log.debug("2");
    }

    public static void main(String[] args) {
        Number2 n1 = new Number2();
        new Thread(() -> {
            try {
                n1.a();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            n1.b();
        }).start();
    }
}
