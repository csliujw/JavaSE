package com.design.factor.abstract_factir;

public interface Human {
    void getColor();
}

class BlackHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("黑人，黑色皮肤");
    }
}

class YellowHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("黄种人，黄色皮肤");
    }
}

