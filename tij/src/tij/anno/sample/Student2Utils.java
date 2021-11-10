package tij.anno.sample;


import java.lang.reflect.Field;

/**
 * 打扰了 不知道怎么重构，设计模式没学好。。
 */
public class Student2Utils {

    // 校验是否存在可操作的字段
    public static boolean validateField(Field[] f) {
        if (f == null || f.length == 0) return false;
        return true;
    }

    // 检查是否包含所需要的注解
    // 有则设置为可访问，并返回true
    // 无则放回false
    public static boolean containerAnnotation(Field arg, Class clazz) {
        if (arg.isAnnotationPresent(clazz)) {
            arg.setAccessible(true);
            return true;
        }
        return false;
    }


    public static String validateLength(Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        if (!validateField(fields)) return null;
        for (Field arg : fields) {
            if (containerAnnotation(arg, Length.class)) {
                Length annotation = arg.getAnnotation(Length.class);
                int length = ((String) arg.get(obj)).length();
                if (length < annotation.min() || length > annotation.max()) {
                    return annotation.message();
                }
            }
        }
        return null;
    }

    public static String validateNotEmpty(Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        if (!validateField(fields)) return null;
        for (Field arg : fields) {
            if (containerAnnotation(arg, NotEmpty.class)) {
                NotEmpty annotation = arg.getAnnotation(NotEmpty.class);
                String o = (String) arg.get(obj);
                if ("".equals(o)) {
                    return annotation.message();
                }
            }
        }
        return null;
    }

    public static String validateNotNull(Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        if (!validateField(fields)) return null;
        for (Field arg : fields) {
            if (containerAnnotation(arg, NotNull.class)) {
                NotNull annotation = arg.getAnnotation(NotNull.class);
                Object o = arg.get(obj);
                if (o == null) {
                    return annotation.message();
                }
            }
        }
        return null;
    }
}
