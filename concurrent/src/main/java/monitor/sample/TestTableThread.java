package monitor;

import lombok.extern.slf4j.Slf4j;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.TestTableThread")
public class TestTableThread {
    public static void main(String[] args) throws InterruptedException {
        Hashtable<String, String> table = new Hashtable<>();
        String key = "keys";
        Thread th1 = new Thread(() -> {
            if (table.get(key) == null) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    table.put(key, "value1");
                    log.debug("value1 放进去了");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread th2 = new Thread(() -> {
            if (table.get(key) == null) {
                try {
                    TimeUnit.SECONDS.sleep(3);
                    table.put(key, "value2");
                    log.debug("value2 放进去了");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        th1.start();
        TimeUnit.SECONDS.sleep(1);
        th2.start();
        th2.join();
        th1.join();
        System.out.println(table.get(key));
    }
}
