package tij.chapter19.aop;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 */
public class DynamicalProxyAOP {

    // 真实对象
    private CommonInterface realObject;

    private DynamicalProxyAOP() {
    }

    public DynamicalProxyAOP(CommonInterface realObject) {
        this.realObject = realObject;
    }

    public static void main(String[] args) {
        DynamicalProxyAOP dynamicalProxyAOP = new DynamicalProxyAOP(new RealObject());
        dynamicalProxyAOP.invoke();
    }

    public void invoke() {
        CommonInterface common = (CommonInterface) Proxy.newProxyInstance(CommonInterface.class.getClassLoader(),
                realObject.getClass().getInterfaces(),
                new ProxyHandler<CommonInterface>(realObject,
                        new AfterAdvice() {
                            @Override
                            public void execute(Object... o) {
                                System.out.println("after advice with args");
                            }

                            @Override
                            public void execute() {
                                System.out.println("after advice");
                            }
                        },
                        new BeforeAdvice() {
                            @Override
                            public void execute() {
                                System.out.println("before advice");
                            }

                            @Override
                            public void execute(Object... o) {
                                System.out.println("before advice with args");
                            }
                        })
        );
        common.doingSomething();
    }
}

class ProxyHandler<T> implements InvocationHandler {
    // 前置通知
    private BeforeAdvice beforeAdvice;
    // 后置通知
    private AfterAdvice afterAdvice;
    private T realObject;

    public ProxyHandler(T realObject) {
        this(realObject, null, null);
    }

    public ProxyHandler(T realObject, AfterAdvice afterAdvice, BeforeAdvice beforeAdvice) {
        this.realObject = realObject;
        this.beforeAdvice = beforeAdvice;
        this.afterAdvice = afterAdvice;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (beforeAdvice != null && args != null) {
            beforeAdvice.execute(args);
        } else if (beforeAdvice != null) {
            beforeAdvice.execute();
        }
        Object invoke = method.invoke(realObject, args);
        if (afterAdvice != null && args != null) {
            afterAdvice.execute();
        } else if (afterAdvice != null) {
            afterAdvice.execute(args);
        }
        return invoke;
    }
}
