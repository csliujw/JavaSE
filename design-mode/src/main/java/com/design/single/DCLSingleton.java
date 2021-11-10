package com.design.single;

/**
 * 双重锁检测的单例模式
 */
public class DCLSingleton {
    // volatile 防止指令重排序
    private volatile DCLSingleton dclSingleton = null;

    private DCLSingleton() {
    }

    public DCLSingleton getInstance() {
        if (dclSingleton == null) {
            synchronized (DCLSingleton.class) {
                if (dclSingleton == null) {
                    dclSingleton = new DCLSingleton();
                }
            }
        }

        return dclSingleton;
    }
}
