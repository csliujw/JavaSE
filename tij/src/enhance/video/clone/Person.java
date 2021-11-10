package video.clone;

public class Person implements Cloneable {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }

    // this method performs a "shallow copy" of this object, not a "deep copy" operation
    @Override
    public Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }
}
