package tij.chapter20;

public class TwoTuple<A, B> {
    final A a;
    final B b;

    TwoTuple(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> two = new TwoTuple<>("Hello", 18);
        System.out.println(two.a);
        System.out.println(two.b);
    }
}
