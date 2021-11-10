package tij.chapter23.format;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleContainer {
    private static Map<Class<?>, Object> instances = new ConcurrentHashMap<>();

    private static <T> T createInstance(Class<T> cls) throws InstantiationException, IllegalAccessException {
        T obj = cls.newInstance();
        Field[] fileds = cls.getDeclaredFields();
        for (Field filed : fileds) {
            if (filed.isAnnotationPresent(Component.class)) {
                if (!filed.isAccessible()) {
                    filed.setAccessible(true);
                }
                Class<?> filedCls = filed.getType();
                filed.set(obj, getInstance(filedCls));
            }
        }
        return obj;
    }

    public static <T> T getInstance(Class<T> cls) {
        try {
            boolean singleton = cls.isAnnotationPresent(Singleton.class);
            if (!singleton) {
                return createInstance(cls);
            }
            Object obj = instances.get(cls);
            if (obj != null) {
                return (T) obj;
            }
            synchronized (cls) {
                obj = instances.get(cls);
                if (obj == null) {
                    obj = createInstance(cls);
                    instances.put(cls, obj);
                }
            }
            return (T) obj;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
