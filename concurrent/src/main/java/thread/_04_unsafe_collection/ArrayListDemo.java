package thread._04_unsafe_collection;

import java.util.ArrayList;

/**
 * Collection线程不安全举例
 */
public class ArrayListDemo {

    public static void unsafeTest1() throws InterruptedException {
        ArrayList<Integer> list = new ArrayList<>();
        Thread[] pool = new Thread[30];

        // 初始化好线程
        for (int i = 0; i < 30; i++) {
            Thread th = new Thread(() -> {
                for (int j = 0; j < 50; j++) {
                    list.add(1);
                }
            });
            pool[i] = th;
        }
        // 开启线程
        for (int i = 0; i < pool.length; i++) {
            pool[i].start();
        }

        while (Thread.activeCount() > 2)
            Thread.yield();
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws InterruptedException {
        unsafeTest1();
    }
}
