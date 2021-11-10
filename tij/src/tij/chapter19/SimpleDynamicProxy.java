package tij.chapter19;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DynamicProxyHandler implements InvocationHandler {
    private Interface realObject;

    public DynamicProxyHandler() {
    }

    public DynamicProxyHandler(Interface realObject) {
        this.realObject = realObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy: " + proxy.getClass() + "\nmethod:" + method + "\nargs:" + args);
        return method.invoke(realObject, args);
    }
}

public class SimpleDynamicProxy {

    public static void main(String[] args) {
        RealObj realObj = new RealObj();

        /**
         * 三个参数，都是接口的
         */
        Interface anInterface = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxyHandler(realObj));
        anInterface.doingSomething();
    }
}
