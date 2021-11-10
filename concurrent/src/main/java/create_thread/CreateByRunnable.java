package create_thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.CreateByRunnable")
public class CreateByRunnable {
    public static void main(String[] args) {
        Runnable task = () -> {
            log.debug("run");
        };
        new Thread(task,"t1").start();
    }
}
