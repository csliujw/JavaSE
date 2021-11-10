package tij.chapter17;

import java.util.Locale;

public class Immutable {
    public static String upcase(String s) {
        return s.toUpperCase(Locale.ROOT);
    }

    public static void main(String[] args) {
        String str = "Hello";
        System.out.println(str + 1 + "asf");
    }
}
