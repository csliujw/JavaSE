package com.design.observer;

public class ZhaoSi implements IObserver {
    @Override
    public void update(String context) {
        System.out.println("赵斯观察到韩非子在 " + context);
        this.doingSomething();
    }

    public void doingSomething() {
        System.out.println("然后也做了同样的事!");
    }
}
