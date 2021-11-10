package source;

import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>(2);
        map.put("1", "1");
        map.put("2", "3");
        map.put("3", "3");
        map.get("1");
        String s = map.get("1");
        map.clear();
    }
}
