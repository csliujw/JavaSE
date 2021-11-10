package com.design.single.geek;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
    private AtomicLong id = new AtomicLong();
    private static final IdGenerator instance = new IdGenerator();


    public static IdGenerator getInstance() {
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        IdGenerator instance = IdGenerator.getInstance();
        System.out.println(instance.getId());
        System.out.println(instance.getId());
        System.out.println(instance.getId());
        System.out.println(instance.getId());
    }

}
