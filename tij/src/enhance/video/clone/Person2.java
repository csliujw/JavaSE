package video.clone;

public class Person2 implements Cloneable {
    private int age;
    // 浅表复制。用的同样的地址
    private Child child;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return "PersonTwo{" +
                "age=" + age +
                ", Child=" + child +
                '}';
    }

    @Override
    public Person2 clone() throws CloneNotSupportedException {
        return (Person2) super.clone();
    }
}

class Child {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
