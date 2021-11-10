package tij.chapter5;

public class MethodInit {

//    int i = g(j);  // 初始化顺序错误，j 初始化在 i的后面，i无法调用j。
    int j = g(10);

    int g(int i) {
        return i * 10;
    }

}
