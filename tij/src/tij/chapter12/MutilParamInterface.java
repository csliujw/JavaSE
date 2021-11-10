package tij.chapter12;

@FunctionalInterface
interface FourSum<T, Y, U, I, R> {
    R apply(T t, Y y, U u, I i);
}

public class MutilParamInterface {
    public static void main(String[] args) {
        // 1. 方法引用
        // 2. lambda 表达式
        FourSum<Integer, Integer, Integer, Integer, Long> f = (x1, x2, x3, x4) -> {
            return (long) (x1 + x2 + x3 + x4);
        };
        System.out.println(f.apply(1, 2, 3, 4));
    }
}
