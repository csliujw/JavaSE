package com.design.template.normal;

public abstract class HummerModel {
    public abstract void start();

    public abstract void stop();

    public void run() {
        this.start();
        System.out.println("doing something");
        this.stop();
    }
}
