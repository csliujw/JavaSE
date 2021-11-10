package tij.chapter23.format;

public class ServiceA {
    @Component
    ServiceB b;

    public void callB() {
        b.action();
    }

    public ServiceB getB() {
        return b;
    }
}
