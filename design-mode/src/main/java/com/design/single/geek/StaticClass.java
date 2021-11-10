package com.design.single.geek;

/**
 * 静态内部类的写法.
 * 静态内部类的初始化顺序？？
 * SingletonHolder 是一个静态内部类，当外部类 StaticClass 被加载的时候，并不会创建
 * SingletonHolder 实例对象。只有当调用 getInstance() 方法时，SingletonHolder 才会
 * 被加载，这个时候才会创建 instance。insance 的唯一性、创建过程的线程安全性，都由
 * JVM 来保证。所以，这种实现方法既保证了线程安全，又能做到延迟加载。
 */
public class StaticClass {
    private StaticClass() {

    }

    private static class SingletonHolder {
        static {
            System.out.println(123);
        }

        private static final IdGenerator instance = new IdGenerator();
    }

    public static IdGenerator getInstance() {
        return SingletonHolder.instance;
    }

    public static void main(String[] args) {
        IdGenerator instance = StaticClass.getInstance();
    }
}
