package video.clone;


public class Test {
    public static void sampleCode() throws CloneNotSupportedException {
        Person person = new Person();
        person.setAge(13);
        Person clone = person.clone();
        System.out.println(person.hashCode());
        System.out.println(clone.hashCode());
    }

    public static void sampleCode2() throws CloneNotSupportedException {
        Person2 p1 = new Person2();
        p1.setAge(12);
        p1.setChild(new Child());
        Person2 p2 = p1.clone();
        System.out.println(String.format("person hash code = %s , child = %s", p1.hashCode(), p1.getChild().hashCode()));
        System.out.println(String.format("clone hash code = %s , child = %s", p2.hashCode(), p2.getChild().hashCode()));
    }


    public static void main(String[] args) throws CloneNotSupportedException {
        sampleCode2();
    }
}
