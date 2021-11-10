package video.proxy.aop;

public class ManWaiterImpl implements IWaiter {
    @Override
    public void serve() {
        System.out.println("Man start serve");
    }
}
