package jvm.candy;

import java.util.ArrayList;

/**
 * 泛型
 */
public class Candy3 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        Integer integer = list.get(0);
    }
}
