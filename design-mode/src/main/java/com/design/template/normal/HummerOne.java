package com.design.template.normal;

/**
 * MyBatis用了模板方法，在BaseExecutor中就运用到了模板方法
 */
public class HummerOne extends HummerModel {
    @Override
    public void start() {
        System.out.println("HummerOne start run....");
    }

    @Override
    public void stop() {
        System.out.println("HummerOne stop~~~~~~~~");
    }

    public static void main(String[] args) {
        HummerOne hummerOne = new HummerOne();
        hummerOne.run();
    }
}
