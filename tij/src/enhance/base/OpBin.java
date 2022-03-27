package enhance.base;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;

public class OpBin {
    /**
     * 位运算相关操作
     */
    public static void main(String[] args) {

        /**
         * & | ^ ~ >> << >>>
         */
        // & 同为1才为1
        int n1 = 10;
        System.out.println((n1 & (n1 - 1))); // 10 = 8+2 = 0000 1010  n1 & (n1 - 1) 可以去掉最右边的一个1 10-->8
        // | 有一个1就是1
        int n2 = 1;
        // n1 |= n2 把 n1 和 n2 bit 为1的都放到 n1 上，且只放一次。 10 = 0000 1010  1 = 0000 0001
        // 10 | 1 = 0000 1011
        // 11 | 1 = 0000 1011 只放一次。
        System.out.println(n1 |= n2);

        // ^ 不同为1，相同为0 n1^n1 = 0; 0^n2 = n2
        System.out.println(n1 ^ n2 ^ n1);
        // ~ 取反
        // n1 = 11 = 0000 1011
        System.out.println(n1);
        // 1111 0100 ==>这是负数的补码 ； 补码取反加1变成原码 1000 1011 + 1 = -(8+2+1+1) = -12
        System.out.println(~n1);

        // << >> 左移 右移动
        System.out.println(n1 >> 1);
        System.out.println(n1 << 1);
        // >>> 无符号右移动。（最高位补0）
        int n3 = -10;
        System.out.println(n3 >>> 2);
        int n4 = Integer.MAX_VALUE;
        System.out.println(Integer.toBinaryString(n4));
        System.out.println(Integer.toBinaryString(n4 << 31));
        System.out.println(n4 << 31);


        System.out.println(Integer.toBinaryString(n4 << 33)); // 11111111111111111111111111111110
        System.out.println(n4 << 33); // -2


        // 操作short
        byte n6 = 127;
        System.out.println(n6<<15);
    }
}
