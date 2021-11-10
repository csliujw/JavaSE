package tij.chapter12;

import java.util.function.IntSupplier;

public class Closure3 {
    IntSupplier makeFun(int x) {
        int i = 0;
        // 报错。
        return () -> x + i;
    }

    public static void main(String[] args) {

    }
}
