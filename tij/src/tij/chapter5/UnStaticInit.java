package tij.chapter5;

public class UnStaticInit {

    public UnStaticInit() {
        System.out.println("unStaticInit");
    }

    Test t1;

    {
        t1 = new Test("用于初始化成员变量的代码块");
    }

    {
        Test test = new Test("单纯的代码块");
    }


    public static void main(String[] args) {
        new UnStaticInit().t1.say();
        int[] a = {};
        System.out.println(a.length);
    }
}

class Test {
    public Test(String msg) {
        System.out.println(msg);
    }

    public void say() {
        System.out.println("hello");
    }
}
