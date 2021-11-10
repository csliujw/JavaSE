package tij.chapter20;

import java.util.ArrayList;
import java.util.List;

public class GenericVarargs {
    public static <T> List<T> makeList(T... args) {
        ArrayList<T> ts = new ArrayList<>();
        for (T arg : args) {
            ts.add(arg);
        }
        return ts;
    }

    public static void main(String[] args) {
        List<Integer> list = makeList(1, 2, 3, 4, 5, 6, 7);
        list.forEach(System.out::println);
    }
}
