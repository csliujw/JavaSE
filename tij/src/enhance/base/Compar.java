package enhance.base;

import java.util.Comparator;
import java.util.TreeSet;

public class Compar {
    static class Com{
        String name;
        int id;
    }

    public static void main(String[] args) {
        Com com = new Com();
        TreeSet<Com> set = new TreeSet<>(new Comparator<Com>() {
            @Override
            public int compare(Com o1, Com o2) {
                return o1.id-o2.id;
            }
        });
        set.add(com);
    }
}

