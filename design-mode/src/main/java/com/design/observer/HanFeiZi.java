package com.design.observer;

import java.util.ArrayList;

public class HanFeiZi implements IHanFeiZi, IObservable {
    private ArrayList<IObserver> observersList = new ArrayList<>();

    @Override
    public void haveBreakfast() {
        System.out.println("被监视者，韩非子开始吃饭！");
        this.notifyObservers("韩非子在吃饭");
    }

    @Override
    public void haveFun() {
        System.out.println("被监视者，韩非子开始打游戏！");
        this.notifyObservers("韩非子在打游戏");
    }

    @Override
    public void addObserver(IObserver observer) {
        observersList.add(observer);
    }

    @Override
    public void deleteObserver(IObserver observer) {
        observersList.remove(observer);
    }

    @Override
    public void notifyObservers(String context) {
        for (IObserver obs : observersList) {
            obs.update(context);
        }
    }
}
