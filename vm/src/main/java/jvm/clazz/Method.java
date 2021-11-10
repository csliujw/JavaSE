package jvm.clazz;

public class Method {
    public Method() {
    }

    private void test1() {
    }

    private final void test2() {
    }

    public void test3() {
    }

    public static void test4() {
    }

    public static void main(String[] args) {
        Method m = new Method();
        m.test1();
        m.test2();
        m.test3();
        m.test4();
        Method.test4();
    }
}