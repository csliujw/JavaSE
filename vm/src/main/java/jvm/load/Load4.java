package jvm.load;

public class Load4 {
    public static void main(String[] args) {
        System.out.println(E.a); // 不会初始化
        System.out.println(E.b); // 不会初始化
        System.out.println(E.c); // 会初始化
        // 看看字节 可以知道为什么会这样。
    }
}

class E {
    public static final int a = 10;
    public static final String b = "hello";
    public static final Integer c = 20;

    static {
        System.out.println("init E");
    }
}