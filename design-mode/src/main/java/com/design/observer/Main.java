package com.design.observer;

/**
 * 观察者模式也叫做发布订阅模式。
 * 定义如下：定义对象间一种一对多依赖关系，使得每当一个对象改变状态，则所有依赖于它的对象都会得到通知并被自动更新！
 * <p>
 * 如果写TankWar，那么我方发送子弹的事件可以用观察者模式，让敌方坦克一直监视，看是否被击中。
 */
public class Main {
    public static void main(String[] args) {
        // 实例化被监视的对象
        HanFeiZi hanFeiZi = new HanFeiZi();
        // 添加监视人员（那些人要监视韩非子）
        hanFeiZi.addObserver(new LiSi());
        hanFeiZi.addObserver(new ZhaoSi());
        // 韩非子一做事情就被监视了！
        hanFeiZi.haveFun();
        System.out.println("==================");
        hanFeiZi.haveBreakfast();
    }
}
