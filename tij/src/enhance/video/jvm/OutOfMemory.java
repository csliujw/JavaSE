package video.jvm;

import java.util.ArrayList;

public class OutOfMemory {
    // Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    public static void main(String[] args) {
        int size = 1024 * 1024;
        ArrayList<Object> objects = new ArrayList<>();
        while (true) {
            objects.add(new String[size]);
        }
    }

}