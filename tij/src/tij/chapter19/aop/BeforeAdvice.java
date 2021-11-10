package tij.chapter19.aop;

public interface BeforeAdvice {
    void execute();

    void execute(Object... o);
}
