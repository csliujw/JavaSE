package unlock;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 多线程 AtomicLong 累加
 */
public class AtomicLongAddDemo {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list1 = Arrays.asList(0, 1, 20, 3, 12, 0, 0, 1, 1, 0, 2, 0, 2, 2, 0, 1, 0, 20);
        List<Integer> list2 = Arrays.asList(0, 0, 20, 3, 12, 0, 0, 1, 1, 0, 2, 0, 2, 2, 0, 1, 0, 20);
        AtomicLong sum = new AtomicLong(0);
        long result = list1.stream().filter(e -> e == 0).count() + list2.stream().filter(e -> e == 0).count();
        Thread th1 = new Thread(() -> {
            list1.stream().filter(e -> e == 0).forEach(e -> sum.getAndIncrement());
        });

        Thread th2 = new Thread(() -> {
            list2.stream().filter(e -> e == 0).forEach(e -> sum.getAndIncrement());
        });
        th1.start();
        th2.start();
        th1.join();
        th2.join();
        System.out.println(result == sum.get());
    }
}
