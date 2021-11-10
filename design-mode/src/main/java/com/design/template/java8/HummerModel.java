package com.design.template.java8;

public interface HummerModel {
    void start();

    void stop();

    public default void run() {
        this.start();
        System.out.println("doing something");
        this.stop();
    }
}
