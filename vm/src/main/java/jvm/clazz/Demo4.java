package jvm.clazz;

public class Demo4 {
    private String a = "s1";

    {
        b = 20;
    }

    private int b = 10;

    {
        a = "s2";
    }

    public Demo4(String a, int b) {
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) {
        Demo4 d = new Demo4("s3", 30);
        System.out.println(d.a);
        System.out.println(d.b);
    }
}
