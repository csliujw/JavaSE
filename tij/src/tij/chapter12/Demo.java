package tij.chapter12;

public class Demo {
    public static void main(String[] args) {
        Test t = new Test<String>();
        t.name(123);

        Test<String> t2 = new Test<>();
        System.out.println(t2);
    }
}

class Test<T> {
    public T name(T t) {
        return t;
    }
}
