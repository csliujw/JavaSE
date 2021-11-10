package com.design.strategy;

public class OpenDoor implements IStrategy {
    @Override
    public void operate() {
        System.out.println("Open the door");
    }
}
