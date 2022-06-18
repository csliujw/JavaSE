package tij.chapter3;

public class Overload {
    void f(char c) {
        System.out.println("f(char)");
    }

    void f(short c) {
        System.out.println("f(short)");
    }

    void f(int c) {
        System.out.println("f(int)");
    }

    void f(long c) {
        System.out.println("f(long)");
    }

    public static void main(String[] args) {
        Overload overload = new Overload();
        byte c = 1;
        overload.f(c);
        overload.f(c);
        overload.f(c);
        overload.f(c);
    }
}
