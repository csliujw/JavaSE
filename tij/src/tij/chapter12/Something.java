package tij.chapter12;

import java.util.function.IntToDoubleFunction;

public class Something {
    public static void main(String[] args) {
        IntToDoubleFunction fid2 = i -> i;
        System.out.println(fid2.applyAsDouble(10));
    }
}
