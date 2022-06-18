package tij.chapter19;

import java.util.ArrayList;
import java.util.List;

public class BoundedClassReferences {
    public static void main(String[] args) {
        List<? extends Number> a1 = new ArrayList<Integer>();
        List<? extends Number> a2 = new ArrayList<Double>();
        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;
        bounded = short.class;
    }
}
