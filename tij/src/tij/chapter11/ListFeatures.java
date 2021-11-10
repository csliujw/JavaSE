package tij.chapter11;

import java.util.*;

public class ListFeatures {
    static class Pet implements Comparable<Pet> {
        String name;

        public Pet(String name) {
            this.name = name;
        }

        static Pet[] names = {new Pet("Dog"), new Pet("Cat"), new Pet("Pig"), new Pet("bee"), new Pet("bird")};

        public List<Pet> getPets() {
            ArrayList<Pet> list = new ArrayList<>(Arrays.asList(names));
            return list;
        }

        @Override
        public int compareTo(Pet o) {
            return this.name.compareTo(o.name);
        }

        @Override
        public String toString() {
            return "Pet{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Pet demo = new Pet("demo");
        List<Pet> pets = demo.getPets();
        Pet h = new Pet("h");

        pets.add(h);
        System.out.println(pets.contains(h));// true

        pets.remove(h);
        Pet pug = new Pet("Pug");
        pets.add(pug);
        System.out.println(pets.indexOf(pug)); // 第一次出现的位置 lastIndexOf 是最后一次出现的位置。

        System.out.println("current elements" + pets);
        List<Pet> subList = pets.subList(2, 5);

        System.out.println("containsAll:" + pets.containsAll(subList)); // 是否包含全部元素。不按顺序也可。

        System.out.println("before sort" + subList);
        Collections.sort(subList); // 对列表进行排序
        System.out.println("after sort" + subList);

        System.out.println("before shuffle containsAll:" + pets.containsAll(subList));
        Collections.shuffle(subList); // 打乱列表
        System.out.println("after shuffle containsAll:" + pets.containsAll(subList));

        List<Pet> pet3 = demo.getPets();
        pet3.remove(1);
        pet3.remove(1);
        pet3.remove(1);

        System.out.println("before retainAll" + subList);
        pet3.retainAll(subList);
        System.out.println("after retainAll" + subList);

        System.out.println("before removeAll" + pet3);
        System.out.println(pet3.removeAll(subList));
        System.out.println("after removeAll" + pet3);

        System.out.println("before addAll" + pet3);
        pet3.addAll(subList);
        System.out.println("after addAll" + pet3);


        Object[] objects = pet3.toArray();
        Pet[] pet4 = pet3.toArray(new Pet[0]);
        System.out.println(pet4[0]);

    }
}
