package video.jvm;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 自定义ClassLoader
 * 类加载器 加载类。
 */
class DemoLoader {

}

public class DefineClassLoader extends ClassLoader {

    public static void main(String[] args) throws ClassNotFoundException {
        DefineClassLoader defineClassLoader = new DefineClassLoader();
        Class<?> aClass = defineClassLoader.loadClass("org.example.video.jvm.DemoLoader");
        System.out.println(aClass);

    }


    @Override
    public Class findClass(String name) {
        byte[] b = loadClassData(name);
        return defineClass(name, b, 0, b.length);
    }


    private byte[] loadClassData(String name) {

        byte[] retVal = new byte[0];
        FileInputStream inputStream = null;
        ByteArrayOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(name);
            outputStream = new ByteArrayOutputStream();
            byte[] buf = new byte[2];
            int len = -1;
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            retVal = outputStream.toByteArray();
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return retVal;
    }
}
