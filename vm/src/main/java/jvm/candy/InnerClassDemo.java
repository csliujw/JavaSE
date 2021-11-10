package jvm.candy;

public class InnerClassDemo {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            int x = 0;

            @Override
            public void run() {
                System.out.println(x);
            }
        };
    }
}
