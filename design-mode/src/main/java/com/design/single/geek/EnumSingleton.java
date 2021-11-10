package com.design.single.geek;

import java.util.concurrent.atomic.AtomicLong;

// 这种实现方式通过Java 枚举类型本身的特性，保证了实例创建的线程安全性和实例的唯一性。
public enum EnumSingleton {
    INSTANCE;
    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        System.out.println(EnumSingleton.INSTANCE.getId());
        System.out.println(EnumSingleton.INSTANCE.getId());
        System.out.println(EnumSingleton.INSTANCE.getId());
        System.out.println(EnumSingleton.INSTANCE.getId());
        System.out.println(EnumSingleton.INSTANCE.getId());
    }
}
