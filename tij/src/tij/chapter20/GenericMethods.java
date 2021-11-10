package tij.chapter20;

import java.util.Map;

public class GenericMethods {
    public <T> void f(T t) {
        System.out.println(t.getClass().getName());
    }

    void p(Map<String,Integer> map){

    }
    public static void main(String[] args) {
        GenericMethods g = new GenericMethods();
        g.f(1);
        g.f("1");
    }
}
