package source;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList(2);
        list.add(0);
        list.remove(Integer.valueOf(0));
    }
}
