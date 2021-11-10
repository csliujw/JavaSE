package com.design.factor.abstract_factir;

public class Main {
    public static void main(String[] args) {
        HumanFactory humanFactory = new HumanFactory();
        BlackHuman human = humanFactory.createHuman(BlackHuman.class);
        human.getColor();
    }
}
