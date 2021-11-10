package jvm.jit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflect1 {
    public static void foo() {
        System.out.println("foo...");
    }

    public static void main(String[] args) throws NoSuchMethodException, Exception, IllegalAccessException {
        Method foo = Reflect1.class.getMethod("foo");
        for (int i = 0; i <= 16; i++) {
            foo.invoke(null);
        }
        System.in.read();
    }
}
