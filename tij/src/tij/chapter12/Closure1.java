package tij.chapter12;

import java.util.function.IntSupplier;

public class Closure1 {
    static int i;

    static IntSupplier makeFun(int x) {
        return () -> x + i++;
    }

    public static void main(String[] args) {
        Closure1 closure1 = new Closure1();
        IntSupplier intSupplier = closure1.makeFun(3);
        IntSupplier intSupplier1 = closure1.makeFun(6);
        int asInt = intSupplier.getAsInt();
        int asInt1 = intSupplier1.getAsInt();
//        System.out.println(asInt);
        System.out.println(i);
//        System.out.println(asInt1);
        System.out.println(i);
//        System.out.println(asInt);
        System.out.println(i);
        System.out.println(i);

    }
}
