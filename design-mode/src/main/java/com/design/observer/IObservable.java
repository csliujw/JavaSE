package com.design.observer;


// 被观察者接口
public interface IObservable {
    // Observer是jdk为观察者模型自行提供的一个类，用于增加，删除观察者对象的。具体去看对于的源码
    public void addObserver(IObserver observer);

    public void deleteObserver(IObserver observer);

    public void notifyObservers(String context);
}
