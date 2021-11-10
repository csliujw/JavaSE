# TIJ = Think in java
TIJ 名不虚传
# 注解的作用
- 减轻样板代码负担。如：直接用注解进行标记，而不是用空接口。方便。
- 减少重复性工作

# 元注解
```java
@Target(ElementType.METHOD) // 作用在那些类型上：字段？方法？类？包？
@Retention(RetentionPolicy.RUNTIME) // 什么级别保存注解？一般选择RUNTIME，可以通过反射获取到。
@Documented // 此注解包含在Javadoc中
@Inherited // 允许子类继承父类中的注解 啥意思？
public @interface Annotation01 {
    // 空注解
}
```

注解解析举例
```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
    int id();

    String description() default "no description";
}

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
//        List<Integer> integers = Arrays.asList(47, 48, 49, 50, 53, 56);
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, 47, 48, 49, 50, 21, 12);
        UseCaseTest.trackUseCass(list, PasswordUtils.class);
    }
}
```
# 注解元素
- 所有基本类型
- String
- Class
- enum
- Annotation
- 以上类型的数组
