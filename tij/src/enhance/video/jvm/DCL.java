package video.jvm;

/**
 * 经典DCL 为什么要volatile？
 * 防止指令重排序
 * 可以看下 即时编译的汇编代码，如何获得，我不知道
 */
public class DCL {
    private volatile static DCL instance;

    public static DCL getInstance() {
        // 这个null是为了提高效率，如果实例化了，就不走锁这步了。
        if (instance == null) {
            // class字节码锁，字节码对象一般唯一
            synchronized (DCL.class) {
                if (instance == null) {
                    /**
                     * 如果不加volatile 那么会有指令重排序的问题
                     * 比如一个对象的初始化分为三个部分：
                     *  1.JVM会分配内存地址、内存空间
                     *  2.使用构造方法实例化对象
                     *  3.instance = 第1步分配好的内存地址
                     *
                     *  如果重排序了，那么可能是 1 3 2的顺序，先给了内存地址，不为null了，
                     *  if判断不为null，直接返回使用了，但是还没实例化对象，调用报错！
                     *  清晰！
                     */
                    instance = new DCL();
                }
            }
        }
        return instance;
    }
}
