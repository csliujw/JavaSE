package video.proxy.aop;

public class TestDemo {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new ManWaiterImpl());
        proxyFactory.setBefore(new IBeforeAdvice() {
            @Override
            public void before() {
                System.out.println("I am before");
            }
        });
//        proxyFactory.setAfter(new IAfterAdvice() {
//            @Override
//            public void after() {
//                System.out.println("I am after");
//            }
//        });
        IWaiter proxy = (IWaiter) proxyFactory.createProxy();
        // 完美
        proxy.serve();
    }
}
