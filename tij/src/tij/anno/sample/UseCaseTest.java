package tij.anno.sample;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PasswordUtils {
    @UseCase(id = 47, description = "password must contain at least one numeric")
    public boolean validatePassword(String password) {
        return password.matches("\\w*\\d\\w*");
    }

    @UseCase(id = 48)
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id = 49, description = "password can't equal previously used ones")
    public boolean checkForNewPassword(List<String> prevPasswords, String password) {
        return !prevPasswords.contains(password);
    }
}

public class UseCaseTest {
    public static void trackUseCass(List<Integer> list, Class<?> clazz) {
        // 获得所有的方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods) {
            // 获取 方法上，UseCase的注解
            UseCase annotation = m.getAnnotation(UseCase.class);
            if (annotation != null) {
                if (list.contains(annotation.id())) {
                    System.out.println(annotation.id() + ":" + annotation.description());
                    list.remove(new Integer(annotation.id()));
                }
            }
        }
        for (Integer i : list) {
            System.out.println(i + " is not find!");
        }

    }

    public static void main(String[] args) {
        // 经典的错误 返回的那个List是 Arrays自定义的一个List，没有remove方法
        // List<Integer> integers = Arrays.asList(47, 48, 49, 50, 53, 56);
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, 47, 48, 49, 50, 21, 12);
        UseCaseTest.trackUseCass(list, PasswordUtils.class);
    }
}
