package com.design.rules;

import java.util.Random;

public class LoD {
    public static void main(String[] args) {
        Wizard wizard = new Wizard();
        for (int i = 0; i < 50; i++) {
            wizard.installWizard();
        }
    }
}

class Wizard {
    private Random rand = new Random(System.currentTimeMillis());

    private int first() {
        System.out.println("first");
        return rand.nextInt(100);
    }

    private int second() {
        System.out.println("second");
        return rand.nextInt(100);
    }

    private int third() {
        System.out.println("third");
        return rand.nextInt(100);
    }

    public void installWizard() {
        int first = this.first();
        if (first > 50) {
            int second = this.second();
            if (second > 50) {
                int third = this.third();
                if (third > 50) {
                    System.out.println("install success");
                }
            }
        }
    }
}