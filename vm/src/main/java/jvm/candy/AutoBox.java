package jvm.candy;

public class AutoBox {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d); // 有缓存
        System.out.println(e == f); // 无缓存
        System.out.println(c == (a + b)); // 有缓存
        // Integer 重写了 equals
        System.out.println(c.equals(a + b)); // 有缓存
        System.out.println(g.equals(a + b)); // 不同类型
    }
}
