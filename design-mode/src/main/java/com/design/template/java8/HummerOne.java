package com.design.template.java8;

/**
 * 模板方法：提前定义好运行的规则。
 */
public class HummerOne implements HummerModel {
    @Override
    public void start() {
        System.out.println("HummerOne start");
    }

    @Override
    public void stop() {
        System.out.println("HummerOne stop");
    }

    public static void main(String[] args) {
        HummerOne hummerOne = new HummerOne();
        hummerOne.run();
    }
}
