package tij.chapter3;

public interface InterfaceDemo {
    public static final int num1 = 10; // OK
    int num2 = 100; // 默认就是 public static final 修饰，且只能是它修饰
//    protected static final int num3 = 10; // 报错
}
