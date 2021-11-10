package com.design.observer;

public class LiSi implements IObserver {
    @Override
    public void update(String context) {
        System.out.println("李斯观察到 " + context);
        this.doingSomething();
    }

    public void doingSomething() {
        System.out.println("然后做了一些其他的规划！");
    }
}
