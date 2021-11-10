package create_thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.CreateByThread")
public class CreateByThread {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1") {
            @Override
            // run 方法内实现了要执行的任务
            public void run() {
                log.debug("run");
            }
        };
        t1.start();
    }
}
