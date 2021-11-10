package tij.chapter12;

import java.util.function.IntSupplier;

public class Closure5 {
    IntSupplier makeFun(int x) {
        int i = 0;
//        i++;
//        x++;
        // 报错
        return () -> x + i;
    }
}
