package enhance.base;

public class TypeCast {
    public static void main(String[] args) {
        // 常见类型转换
        // char byte short 在计算的时候会提升为int。
        char n1 = 0;
        // n1 = n1+2; 报错。
        n1+=2; // 会有默认的隐式类型转换
    }
}
