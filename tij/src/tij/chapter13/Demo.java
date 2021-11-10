package tij.chapter13;

import java.util.function.Function;

public class Demo {
    public Function getFunc() {
        return s -> {
            System.out.println(123);
            return "2";
        };
    }
}
