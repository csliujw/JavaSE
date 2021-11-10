package tij.chapter23.create_table;

@DBTable(name = "member")
public class Member {
    // value 为唯一一个需要赋值的元素，你就不需要使用
    //名—值对的语法，你只需要在括号中给出 value 元素的值即可
    @SQLString(100)
    String firstName;

    @SQLString(100)
    String lastName;
    @SQLInteger
    Integer age;
    @SQLString(value = 30, constraints = @Constraints(primaryKey = true))
    String reference;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
