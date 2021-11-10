package tij.chapter19.aop;

public interface AfterAdvice {
    void execute(Object... o);

    void execute();
}
