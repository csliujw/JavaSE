package tij.chapter19;

import java.util.ArrayList;
import java.util.Random;

class Initable {
    static final int STATIC_FINAL = 47;
    static final int STATIC_FINAL2 = ClassInitialization.rand.nextInt(1000);

    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {
    static int staticNonFinal = 147;

    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 74;

    static {
        System.out.println("Initializing Initable3");
    }
}

public class ClassInitialization {
    public static Random rand = new Random(47);

    public static void main(String[] args) throws Exception {
        Class initable = Initable.class; // 不会触发类的初始化
        System.out.println("After creating Initable ref");
        // 不会触发初始化
        System.out.println(Initable.STATIC_FINAL);
        // 会触发初始化
        System.out.println(Initable.STATIC_FINAL2);
        // 不会触发初始化
        System.out.println(Initable2.staticNonFinal);
        // 会触发初始化
        Class initable3 = Class.forName("tij.chapter19.Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);

        ArrayList<A> arrayList = new ArrayList();
        arrayList.add(new A());
        arrayList.add(new B());

    }
    static class A{}
    static class B extends A{}
    static class C extends A{}
}
