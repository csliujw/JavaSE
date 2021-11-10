//package video.generic;
//
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//
///**
// * 泛型的高级用法
// * > 限制泛型可用类型和使用类型通配符
// * class ClassName<T extends anyClass>
// * > 使用类型通配符
// * genericName< ? extends List > a = null
// */
//public class Senior {
//    /**
//     * 伪泛型 会报错
//     * public void say(List<String> list1) {
//     * }
//     * public void say(List<Integer> list1) {
//     * }
//     */
//
//    public static void main(String[] args) {
//        Senior senior = new Senior();
//        senior.test4();
//    }
//
//
//    // 限制泛型的使用类型
//    public void test1() {
//        LimitClass<ArrayList> c1 = new LimitClass<>();
//        LimitClass<LinkedList> c2 = new LimitClass<>();
//        // 报错，因为HashMap并不 extends List
//        // LimitClass<HashMap> c3 = new LimitClass<>();
//    }
//
//    // 基本的泛型使用后 用反射越过泛型检查
//    public void test2() {
//        ArrayList<String> strings = new ArrayList<>();
//        List o = (List) Proxy.newProxyInstance(ArrayList.class.getClassLoader(), strings.getClass().getInterfaces(), new InvocationHandlerDemo<ArrayList<String>>(strings));
//        o.add(123);
//        // 越过了泛型检查
//        System.out.println(strings.size());
//    }
//
//    // 限定泛型使用后 用反射越过泛型检查s
//    public void test3() {
//        ArrayList<? extends String> s = new ArrayList<>();
//        List o = (List) Proxy.newProxyInstance(ArrayList.class.getClassLoader(), s.getClass().getInterfaces(), new InvocationHandlerDemo<ArrayList<String>>((ArrayList<String>) s));
//        o.add(123);
//        // 越过了泛型检查
//        System.out.println(s.size());
//    }
//
//    // 限定泛型使用后 用反射越过泛型检查s
//    public void test4() {
//        var s = new ArrayList<String>();
//        var o = (List) Proxy.newProxyInstance(ArrayList.class.getClassLoader(), s.getClass().getInterfaces(), new InvocationHandlerDemo<ArrayList<String>>(s));
//        o.add(123);
//        // 越过了泛型检查
//        System.out.println(s.size());
//    }
//
//
//    /**
//     * =================================
//     * ==============内部类==============
//     * =================================
//     */
//    static class LimitClass<T extends List> {
//
//    }
//
//    static class InvocationHandlerDemo<T> implements InvocationHandler {
//        private T target = null;
//
//        public InvocationHandlerDemo() {
//        }
//
//        public InvocationHandlerDemo(T target) {
//            this.target = target;
//        }
//
//        @Override
//        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//            System.out.println("add elements");
//            Object o = method.invoke(target, args);
//            return o;
//        }
//    }
//}
