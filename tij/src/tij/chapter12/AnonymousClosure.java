package tij.chapter12;

import java.util.function.IntSupplier;

public class AnonymousClosure {
    IntSupplier makeFun(int x) {
        int i = 0;
        // 同样规则的应用:
        // i++; // 非等同 final 效果
        // x++; // 同上
        return new IntSupplier() {
            public int getAsInt() {
                return x + i;
            }
        };
    }
}