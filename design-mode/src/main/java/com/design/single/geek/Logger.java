package com.design.single.geek;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 日志类的例子
 */
public class Logger {
    private FileWriter writer;
    private static final Logger logger = new Logger();

    public static Logger getInstance() {
        return logger;
    }

    private Logger() {
        File file = new File("./log.txt");
        try {
            writer = new FileWriter(file, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void log(String message) throws IOException {
        // write方法是加了锁的，锁的对象是 FileWriter对象本身 如果每次调用的FileWriter对象都是同一个就不会有安全问题。
        // 单例模式派上用场了~ 我们把Logger类变成单例，则其对应的成员变量FileWriter也是单例的。
        writer.write(message + "\n\r");
        writer.flush();
    }

    public void close() {
        try {
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Logger instance = Logger.getInstance();
        instance.log("12323");
        instance.log("hello");
        instance.log("hello");
    }
}
