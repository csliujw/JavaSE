package tij.chapter19;


/**
 * 静态代理。
 * 基本上，GoF 23 种设计模式都是基于多态的
 */
interface Interface {
    void doingSomething();

    void somethingElse();
}

class RealObj implements Interface {

    @Override
    public void doingSomething() {
        System.out.println("RealObj doingSomething");
    }

    @Override
    public void somethingElse() {
        System.out.println("RealObj somethingElse");
    }
}

class SimpleProxyObj implements Interface {
    public static void main(String[] args) {
        SimpleProxyObj proxy = new SimpleProxyObj(new RealObj());
        proxy.doingSomething();
        proxy.somethingElse();
    }

    private Interface realObj;

    public SimpleProxyObj() {

    }

    public SimpleProxyObj(Interface realObj) {
        this.realObj = realObj;
    }

    @Override
    public void doingSomething() {
        realObj.doingSomething();
        System.out.println("Proxy Object doingSomething");
    }

    @Override
    public void somethingElse() {
        realObj.somethingElse();
        System.out.println("Proxy Object somethingElse");
    }
}






























/*
interface Interface {
    void doSomething();

    void somethingElse(String arg);
}

class RealObject implements Interface {
    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}

class SimpleProxy implements Interface {
    private Interface proxied;

    SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        System.out.println("SimpleProxy doSomething");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println(
                "SimpleProxy somethingElse " + arg);
        proxied.somethingElse(arg);
    }
}

public class SimpleProxyDemo {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}
*/