package com.design.strategy;

public class Main {
    public static void main(String[] args) {
        Context context = null;
        context = new Context(new OpenDoor());
        context.operate();
        context = new Context(new GreenLight());
        context.operate();
    }
}
