package tij.chapter11;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.toArray(new Integer[5]);
        System.out.printf("%s", list.subList(5, 8));
    }
}
