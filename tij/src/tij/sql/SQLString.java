package tij.sql;



import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
/**
 * SQL的类型
 */
public @interface SQLString {
    int value() default 0; // String的长度

    String name() default "";

    Constraints constraints() default @Constraints;
}

