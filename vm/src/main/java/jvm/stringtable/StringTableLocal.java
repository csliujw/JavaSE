package jvm.stringtable;

import java.util.ArrayList;

/**
 * jdk8设置：-Xmx10m -XX:-UseGCOverheadLimit
 * jdk6设置：-XX:MaxPermSie=10m
 */
public class StringTableLocal {
    /**
     * Java 11 报异常：OutOfMemoryError: Java heap space 堆内存溢出了。说明StringTable在 heap 里面
     *
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<String> table = new ArrayList<>();
        int i = 0;
        try {
            for (int j = 0; j < 260000000; j++) {
                String.valueOf(j).intern();
                i++;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println(i);
        }
    }
}
