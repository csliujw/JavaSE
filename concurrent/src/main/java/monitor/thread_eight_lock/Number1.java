package monitor.thread_eight_lock;

import lombok.extern.slf4j.Slf4j;

// 1 2 或 2 1
@Slf4j(topic = "c.Number")
public class Number1 {
    public synchronized void a() {
        log.debug("1");
    }

    public synchronized void b() {
        log.debug("2");
    }

    public static void main(String[] args) {
        Number1 n1 = new Number1();
        new Thread(() -> {
            n1.a();
        }).start();
        new Thread(() -> {
            n1.b();
        }).start();
    }
}
