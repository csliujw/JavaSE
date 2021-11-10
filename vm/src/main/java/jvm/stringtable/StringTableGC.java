package jvm.stringtable;

// -Xmx10m -XX:+PrintStringTableStatistics -XX:+PrintGCDetails -verbose:gc
public class StringTableGC {
    public static void main(String[] args) {
        int i = 0;
        try {
            for (int j = 0; j < 10000; j++) {
                String.valueOf(i).intern();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println(i);
        }
    }
}
