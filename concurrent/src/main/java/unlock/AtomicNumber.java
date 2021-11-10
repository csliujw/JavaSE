package unlock;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicNumber {
    public static void updateAndGet() {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        while (true) {
            int pre = atomicInteger.get();
            int next = pre * 10;
            if (atomicInteger.compareAndSet(pre, next)) {
                break;
            }
        }
        System.out.println(atomicInteger.get());
    }

    public static void main(String[] args) {
        AtomicNumber.updateAndGet();
//        AtomicInteger number = new AtomicInteger(0);
//        // 获取并自增（i = 0, 结果 i = 1, 返回 0），类似于 i++
//        System.out.println(number.getAndIncrement());
//        // 自增并获取（i = 1, 结果 i = 2, 返回 2），类似于 ++i
//        System.out.println(number.incrementAndGet());
//        // 自减并获取（i = 2, 结果 i = 1, 返回 1），类似于 --i
//        System.out.println(number.decrementAndGet());
//        // 获取并自减（i = 1, 结果 i = 0, 返回 1），类似于 i--
//        System.out.println(number.getAndDecrement());
//        // 获取并加值（i = 0, 结果 i = 5, 返回 0）
//        System.out.println(number.getAndAdd(5));
//        // 加值并获取（i = 5, 结果 i = 0, 返回 0）
//        System.out.println(number.addAndGet(-5));
//        // 获取并更新（i = 0, p 为 i 的当前值, 结果 i = -2, 返回 0）
//        // 其中函数中的操作能保证原子，但函数需要无副作用
//        System.out.println(number.getAndUpdate(p -> p - 2));
//        // 更新并获取（i = -2, p 为 i 的当前值, 结果 i = 0, 返回 0）
//        // 其中函数中的操作能保证原子，但函数需要无副作用
//        System.out.println(number.updateAndGet(p -> p + 2));
//        // 获取并计算（i = 0, p 为 i 的当前值, x 为参数1, 结果 i = 10, 返回 0）
//        // 其中函数中的操作能保证原子，但函数需要无副作用
//        // getAndUpdate 如果在 lambda 中引用了外部的局部变量，要保证该局部变量是 final 的
//        // getAndAccumulate 可以通过 参数1 来引用外部的局部变量，但因为其不在 lambda 中因此不必是 final
//        System.out.println(number.getAndAccumulate(10, (p, x) -> p + x));
//        // 计算并获取（i = 10, p 为 i 的当前值, x 为参数1, 结果 i = 0, 返回 0）
//        // 其中函数中的操作能保证原子，但函数需要无副作用
//        System.out.println(number.accumulateAndGet(-10, (p, x) -> p + x));
//
    }
}
