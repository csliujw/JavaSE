package tij.chapter9;

public interface InterfaceField {
    // 默认是且只能是 public static final 的
    public static final int count = 10;
    // 不含方法体的方法默认是且只能是 public abstract
    public abstract void say();
}

class Test {

    public static int a = 10;

    public static void main(String[] args) {
        System.out.println(InterfaceField.count);
    }
}