package com.design.strategy;

public class GreenLight implements IStrategy {
    @Override
    public void operate() {
        System.out.println("绿灯放行");
    }
}
