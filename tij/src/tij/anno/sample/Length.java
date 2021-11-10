package tij.anno.sample;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD}) // 定义注解作用于什么位置
@Retention(RetentionPolicy.RUNTIME) // 定义注解的生命周期
public @interface Length {
    int min();

    int max();

    String message();
}
