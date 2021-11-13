//package unlock;
//
//import lombok.Data;
//import sun.misc.Unsafe;
//
//import java.lang.reflect.Field;
//
//public class UnsafeDemo {
//    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
//        theUnsafe.setAccessible(true);
//        Unsafe unsafe = (Unsafe) theUnsafe.get(null);
//        System.out.println(unsafe);
//        // id 的偏移量地址
//        long idOffset = unsafe.objectFieldOffset(Student.class.getDeclaredField("id"));
//        long nameOffset = unsafe.objectFieldOffset(Student.class.getDeclaredField("name"));
//        Student student = new Student();
//        unsafe.compareAndSwapInt(student, idOffset, 0, 1);
//        unsafe.compareAndSwapObject(student, nameOffset, null, "hello");
//        System.out.println(student);
//    }
//}
//
//@Data
//class Student {
//    volatile int id;
//    volatile String name;
//}
