package jvm.clazz;

public class Demo3 {
    static int i = 10;

    static {
        i = 20;
    }

    static {
        i = 30;
    }

    public static void main(String[] args) {
        System.out.println(i); //结果为30
    }
}