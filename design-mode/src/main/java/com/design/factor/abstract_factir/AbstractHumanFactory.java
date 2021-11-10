package com.design.factor.abstract_factir;

public abstract class AbstractHumanFactory {
    // 泛型的继承。参数类型得是T，即参数类型要是Human的子类
    public abstract <T extends Human> T createHuman(Class<T> c);
}
