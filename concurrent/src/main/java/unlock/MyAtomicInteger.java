package unlock;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

class MyAtomicInteger {
    private volatile int value;
    private static long valueOffset;
    private static Unsafe UNSAFE = null;

    public MyAtomicInteger() {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            UNSAFE = (Unsafe) theUnsafe.get(null);
            valueOffset = UNSAFE.objectFieldOffset(MyAtomicInteger.class.getDeclaredField("value"));

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public int getValue() {
        return value;
    }

    public void decrement(int amount) {
        while (true) {
            int pre = this.value;
            int next = pre - amount;
            if (UNSAFE.compareAndSwapInt(this, valueOffset, pre, next)) {
                break;
            }
        }
    }
}

