package jvm.clazz;

import java.io.IOException;

/**
 * 禁用指针压缩
 * -XX:-UseCompressedOops -XX:-UseCompressedClassPointers
 */
public class Demo3_3 {
    public static void test(Animal animal) {
        animal.eat();
        System.out.println(animal.toString());
    }

    public static void main(String[] args) throws IOException {
        test(new Cat());
        test(new Dog());
        System.in.read();
    }
}

abstract class Animal {
    public abstract void eat();

    @Override
    public String toString() {
        return "I am" + this.getClass().getSimpleName();
    }
}

class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("gu tou");
    }
}

class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("yu");
    }
}
