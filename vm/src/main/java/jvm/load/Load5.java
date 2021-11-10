package jvm.load;

public class Load5 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("jvm.load.F");
        System.out.println(aClass.getClassLoader());
    }

}