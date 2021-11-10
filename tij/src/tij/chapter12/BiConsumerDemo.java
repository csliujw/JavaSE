package tij.chapter12;


import java.util.function.BiConsumer;

class A {
    {
        System.out.println("消费了A");
    }
}

class B {
    {
        System.out.println("消费了B");
    }
}

public class BiConsumerDemo {
    static void acceptDemo(A a, B b) {
        System.out.println("acceptDemo");
    }

    public static void lambdaDemo() {
        BiConsumer<A, B> bic = (t1, t2) -> {
            System.out.println("lambdaDemo");
        };
        bic.accept(new A(), new B());
    }


    public static void main(String[] args) {
        // 1. lambda 实现方法
        lambdaDemo();
        // 2. 方法引用赋值
        BiConsumer<A, B> bic = BiConsumerDemo::acceptDemo;
        // 赋值后使用
        bic.accept(new A(), new B());
    }
}
