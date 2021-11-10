package jvm.concurrence;

public class DCL {
    private DCL() {
    }

    private static DCL INSTANCE = null;

    public static DCL getInstance() {
        // 实例没创建，才会进入内部的 synchronized代码块
        if (INSTANCE == null) {
            synchronized (DCL.class) {
                // 也许有其它线程已经创建实例，所以再判断一次
                if (INSTANCE == null) {
                    INSTANCE = new DCL();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        System.out.println(1);
    }
}
