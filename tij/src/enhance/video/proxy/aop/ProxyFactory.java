package video.proxy.aop;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    private Object target;
    private IBeforeAdvice before;
    private IAfterAdvice after;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public ProxyFactory() {

    }

    public Object createProxy() {
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class[] interfaces = target.getClass().getInterfaces();
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (before != null) {
                    before.before();
                }
                Object retVal = method.invoke(target);
                if (after != null) {
                    after.after();
                }
                return retVal;
            }
        };
        Object o = Proxy.newProxyInstance(classLoader, interfaces, handler);
        return o;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public IBeforeAdvice getBefore() {
        return before;
    }

    public void setBefore(IBeforeAdvice before) {
        this.before = before;
    }

    public IAfterAdvice getAfter() {
        return after;
    }

    public void setAfter(IAfterAdvice after) {
        this.after = after;
    }
}
