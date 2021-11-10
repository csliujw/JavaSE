package thread._03_longAdder;

import java.util.concurrent.atomic.LongAdder;

/**
 * CAS机制优化。与AtomicLong效果相同。对CAS机制的优化。<br>
 * 核心思想：将热点数据分离，把一个变量分解为多个变量，让同样多的线程取竞争多个资源<br>
 * - 使用AtomicLong时，是多个线程同时竞争同一个原子变量。
 * - 使用LongAdder时，则是再内部维护多个Cell变量，每个Cell变量里有一个初始值为0的long变量，这样同等
 * 并发量下，线程的竞争会小很多。如果多个线程竞争同一个cell失败了，不会一直竞争这个cell，回去考虑争夺
 * 其他cell。获取值时是累加后返回。
 * -
 */
public class LongAdderDemo {
    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();
        longAdder.increment();
        longAdder.add(10);
        /**
         *     public void add(long x) {
         *         Cell[] cs; long b, v; int m; Cell c;
         *         if ((cs = cells) != null || !casBase(b = base, b + x)) {
         *             boolean uncontended = true;
         *             if (cs == null || (m = cs.length - 1) < 0 ||
         *                 (c = cs[getProbe() & m]) == null ||
         *                 !(uncontended = c.cas(v = c.value, v + x)))
         *                 longAccumulate(x, null, uncontended);
         *         }
         *     }
         */
        System.out.println(longAdder);
    }
}
