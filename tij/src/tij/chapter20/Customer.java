package tij.chapter20;

class PointA {
    int x, y;
}

class PointB {
    int x, y;
}

public class Customer<A, B> {
    public A a;
    public B b;

    Customer(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) {
        Customer<PointA, PointB> c = new Customer<>(new PointA(), new PointB());
        System.out.println(c.a);
        System.out.println(c.b);
    }
}
