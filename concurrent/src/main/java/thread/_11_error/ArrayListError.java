package thread._11_error;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * 可能出现的情况
 * - 程序正常结束，ArrayList的最终大小确实200万
 * - 程序抛出异常。这是因为ArrayList在扩容过程中，内部一致性被破坏，但由于没有锁的保护，另外一个线程访问到了不一致的内部状态，导致出现越界问题。
 * - 出现了一个非常隐蔽的错误，比如打印如下值作为ArrayList的大小。1271885
 */
public class ArrayListError {
    static ArrayList<Integer> list = new ArrayList<Integer>(10);


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                list.add(i);
            }
            countDownLatch.countDown();
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                list.add(i);
            }
            countDownLatch.countDown();
        }).start();

        countDownLatch.await();
        System.out.println(list.size());
    }
}
