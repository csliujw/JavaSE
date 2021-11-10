package jvm.stringtable;

public class StringTable {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;
        System.out.println(s3 == s4); // new StringBuilder().append("a").append("b").toString() new String("ab")  false
        String s5 = "a" + "b"; // javac 在编译器的优化，都是常量，拼接的结果是确定的，是 ab。
    }
}
