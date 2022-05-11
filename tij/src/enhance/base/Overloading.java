package enhance.base;

public class Overloading {
    void f(char c) {
        System.out.println("char");
    }

    void f(short c) {
        System.out.println("short");
    }

    public static void main(String[] args) {
        Overloading overloading = new Overloading();
        byte b = 1;
        overloading.f(b);
    }
}
