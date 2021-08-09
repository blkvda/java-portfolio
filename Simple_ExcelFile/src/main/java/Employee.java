public class Employee {
    private String firstname;
    private String lastname;
    private Integer age;
    private String position;

    public Employee(String firstname, String lastname, Integer age, String position) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.position = position;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Integer getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                '}';
    }
}
