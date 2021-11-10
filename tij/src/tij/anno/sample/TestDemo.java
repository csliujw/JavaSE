package tij.anno.sample;

import java.lang.reflect.Field;

public class TestDemo {
    @Length(min = 2, max = 5, message = "请确保min>=2 & max<=5")
    public String name;

    public static String validate(Object obj) throws IllegalArgumentException, IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field arg : fields) {
            if (arg.isAnnotationPresent(Length.class)) {
                Length annotation = arg.getAnnotation(Length.class);
                arg.setAccessible(true);
                int value = ((String) arg.get(obj)).length();
                if (value < annotation.min() || value > annotation.max()) {
                    return annotation.message();
                }
            }
        }
        return "OK";
    }

    public static void main(String[] args) throws IllegalAccessException {
        TestDemo testDemo = new TestDemo();
        testDemo.name = "hellasfasf";
        System.err.println(validate(testDemo));

    }
}
