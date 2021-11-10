package monitor;

import java.util.concurrent.TimeUnit;

public class Sleeper {
    public static void sleep(long timeout){
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
