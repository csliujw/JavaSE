package tij.chapter11;

import java.util.ArrayList;
import java.util.Collection;

public class SimpleCollection {
    public static void main(String[] args) {
        Collection<Integer> elements = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            elements.add(i);
        }
        for (Integer i : elements) {
            System.out.println(i);
        }
    }
}
