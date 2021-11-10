package tij.anno.sample;


public class Student2 {

    @Length(min = 2, max = 10, message = "are you ok??")
    @NotNull(message = "null point")
    @NotEmpty(message = "no value")
    public String name;

    public static void main(String[] args) throws IllegalAccessException {
        Student1 student = new Student1();
        student.name = "";
        System.err.println(Student2Utils.validateLength(student));
        System.err.println(Student2Utils.validateNotNull(student));
        System.err.println(Student2Utils.validateNotEmpty(student));
    }
}
