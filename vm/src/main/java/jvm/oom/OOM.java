package jvm.oom;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * VM option: -Xmx50m -Xms10m
 */
public class OOM {
    public static void main(String[] args) {
        int i = 0;
        try {
            ArrayList<Object> list = new ArrayList<>();
            String a = "hello";
            while (true) {
                Object[] obj = new Object[5 * 1024];
                list.add(obj);
                TimeUnit.SECONDS.sleep(10);
                System.gc();
            }
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println(i);
        }
    }
}
