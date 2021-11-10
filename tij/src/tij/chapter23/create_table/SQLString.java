package tij.chapter23.create_table;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLString {
    // varchar长度限制
    int value() default 0;

    String name() default "";

    Constraints constraints() default @Constraints;
}
