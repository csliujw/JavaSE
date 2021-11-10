package tij.chapter5;

public class PraticeFive {
    public static void main(String[] args) {
        new A();
    }
}

class A extends C {
    A() {
        System.out.println("A");
    }
}

class B {
    B() {
        System.out.println("B");
    }
}

class C {
    private B b = new B();

    C() {
        System.out.println("C");
    }
}