package tij.chapter19;

class D {
    static final int a = 10;

    static {
        System.out.println("INIT");
    }
}

public class Test {
    public static void main(String[] args) {
        System.out.println(D.class);
    }
}
