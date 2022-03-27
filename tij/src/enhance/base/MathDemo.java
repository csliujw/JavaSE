package enhance.base;

import java.math.BigDecimal;
import java.math.MathContext;

public class MathDemo {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(12.562);
        MathContext mathContext1 = new MathContext(1);
        MathContext mathContext3 = new MathContext(3);
        MathContext mathContext5 = new MathContext(5);
        MathContext mathContext10 = new MathContext(10);
        System.out.println(bigDecimal.round(mathContext1));
        System.out.println(bigDecimal.round(mathContext3));
        System.out.println(bigDecimal.round(mathContext5));
        System.out.println(bigDecimal.round(mathContext10));
    }
}
