package com.design.single.geek;

/**
 * 懒汉式
 */
public class LazySingleton {
    private static LazySingleton instance = null;

    private LazySingleton() {

    }

    // 这把synchronized是class级别的。
    public static synchronized LazySingleton getInstance() {
        if (null == instance) {
            instance = new LazySingleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        LazySingleton instance1 = LazySingleton.getInstance();
        LazySingleton instance2 = LazySingleton.getInstance();
        LazySingleton instance3 = LazySingleton.getInstance();
        System.out.println(instance1 == instance2);
        System.out.println(instance2 == instance3);
    }
}
