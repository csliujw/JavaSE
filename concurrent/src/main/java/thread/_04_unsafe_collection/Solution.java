package thread._04_unsafe_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ArrayList线程不安全怎么办？用Vector或者Collections.synchronized()
 */
public class Solution {

    // 用将ArrayList转为线程安全的List
    public static void solutionTest1() throws InterruptedException {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());

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


    // 直接使用Vector这个线程安全的类
    public static void solutionTest2() throws InterruptedException {
        Vector<Integer> list = new Vector<>();
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


    /**
     * 对集合进行修改操作都是在底层的一个复制数组（快照）上进行的，使用了写时复制的操作。
     * 写时复制：写的时候，先把数据复制一份，在复制的那份数据上操作。操作完成后再修改指针的引用。
     * 底层原先用的ReentrantLock，后来改成了synchronized。
     * 适用于读多写少，或者要求可同时多个线程读，只允许一个线程写。
     */
    public static void solutionTest3() {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
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
        solutionTest3();
    }
}
