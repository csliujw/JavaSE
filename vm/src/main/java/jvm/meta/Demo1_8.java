package jvm.meta;

//import jdk.internal.org.objectweb.asm.ClassWriter;
//import jdk.internal.org.objectweb.asm.Opcodes;
//
//// 演示元空间溢出
//public class Demo1_8 extends ClassLoader { // 继承 ClassLoader 可以用来加载类的二进制字节码
//    public static void main(String[] args) {
//        int j = 0;
//        Demo1_8 demo1_8 = new Demo1_8();
//        try {
//            for (int i = 0; i < 10000; i++, j++) {
//                // ClassWriter 作用是生成类的二进制字节码
//                ClassWriter cw = new ClassWriter(0);
//                // 版本号 public 类名 包名 父类 接口
//                cw.visit(Opcodes.V1_8,
//                        Opcodes.ACC_PUBLIC,
//                        "Class" + i,
//                        null,
//                        "java/lang/Object",
//                        null);
//                // 返回 byte[]
//                byte[] code = cw.toByteArray();
//                // 执行了类的加载
//                demo1_8.defineClass("Class" + i, code, 0, code.length);
//            }
//        } catch (Throwable e) {
//            e.printStackTrace();
//        } finally {
//            System.out.println(j);
//        }
//    }
//}
