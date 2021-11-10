package tij.chapter19.aop;

public class RealObject implements CommonInterface {
    @Override
    public void doingSomething() {
        System.out.println("Real Object doing something");
    }

    @Override
    public void doingSomething(int count) {
        System.out.println("Real Object doing something with args");
    }
}
