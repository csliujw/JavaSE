package video.reflect.document;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Class student = null;
        student = Class.forName("org.example.video.reflect.document.Student");
//        System.out.println(student.hashCode()); // hashCode不唯一
        System.out.println("public field");
        testPublicField(student);
        System.out.println("===============");
        System.out.println("declared field");
        testDeclaredField(student);
        System.out.println("==============");
        getStudentObject();
        System.out.println("==============");
        testMethodExecute(student);
    }

    /**
     * 可以得到 父类public 修饰的 和子类非private的
     *
     * @param clazz
     */
    public static void testPublicField(Class clazz) {
        Field[] fields = clazz.getFields();
        for (Field f : fields) {
            System.out.format("%s\n", f.getName());
        }
    }

    /**
     * 无法得到父类的哦！ 只能得到自身的 private ~ public
     *
     * @param clazz
     */
    public static void testDeclaredField(Class clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            System.out.format("%s\n", f.getName());
        }
    }

    /**
     * method 和 构造都是一样的规则
     */

    public static Student getStudentObject() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        /**
         * Class.forName 后 newInstance() Java 9废弃了
         * @Deprecated(since="9")
         * public T newInstance()
         */
        Class clazz = Class.forName("org.example.video.reflect.document.Student");
        Student stu1 = (Student) clazz.newInstance();

        /**
         * 通过构造器
         * 构造器.newInstance() 未被废弃
         */
        Constructor constructor = clazz.getConstructor(String.class);
        Student stu2 = (Student) constructor.newInstance("className");
        System.out.println(stu2.className);
        return null;
    }

    /**
     * 执行反射得到的方法
     */
    public static void testMethodExecute(Class clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Method getAddress = clazz.getMethod("getAddress");
        Student stu = (Student) clazz.getConstructor().newInstance();
        System.out.println(stu);
        stu.setAddress("setAddress");
        System.out.println(getAddress.invoke(stu));
    }

    public void note() {
        /**
         * Java 9废弃了 直接 clazz.newInstance的方法 改用了
         * clazz.getDeclaredConstructor().newInstance();
         */
    }
}
