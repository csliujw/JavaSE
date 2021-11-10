package thread._11_error;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * HashMap也不是线程安全的
 * - 第一，程序正常结束，并且结果也是符合预期的，HashMap的大小为100 000。
 * - 第二，程序正常结束，但结果不符合预期，而是一个小于200000的数字，比如128 868。
 * - 第三，程序永远无法结束。(JDK8已经修复了。)由于多线程的冲突，这个链表的结构已经遭到了破坏，链表成环了！当链表成环时，上述的迭代就等同于一个死循环
 */
public class HashMapError {
    static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
            System.out.println(map.size());
        });
        new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                map.put(Integer.toString(i), Integer.toBinaryString(i));
            }
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                map.put(Integer.toString(i), Integer.toBinaryString(i));
            }
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
