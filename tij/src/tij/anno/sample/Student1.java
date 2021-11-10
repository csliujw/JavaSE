package tij.anno.sample;


import java.lang.reflect.Field;

/**
 * 如此丑陋的写法怎么可以上台面，重构一下，改善既有代码设计
 */
@NotNull
public class Student1 {

    //    @Length(min = 2, max = 10, message = "are you ok??")
    @NotNull(message = "null point")
    @NotEmpty(message = "no value")
    public String name;

    public static void main(String[] args) throws IllegalAccessException {
        Student1 student = new Student1();
        student.name = "";
        System.out.printf(validate(student));
    }

    /**
     * 获得所有字段，对字段进行注解校验
     *
     * @param obj
     * @return
     * @throws IllegalArgumentException
     */
    public static String validate(Object obj) throws IllegalArgumentException, IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field arg : fields) {
            if (arg.isAnnotationPresent(Length.class)) {
                arg.setAccessible(true);
                Length annotation = arg.getAnnotation(Length.class);
                int length = ((String) arg.get(obj)).length();
                if (length < annotation.min() || length > annotation.max()) {
                    return annotation.message();
                }
            } else if (arg.isAnnotationPresent(NotEmpty.class)) {
                arg.setAccessible(true);
                NotEmpty annotation = arg.getAnnotation(NotEmpty.class);
                String o = (String) arg.get(obj);
                if ("".equals(o)) {
                    return annotation.message();
                }
            } else if (arg.isAnnotationPresent(NotNull.class)) {
                arg.setAccessible(true);
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
