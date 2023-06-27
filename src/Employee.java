public class Employee {
    private String name;
    @EmployeeAnnotation
    private String lastName;
    @EmployeeAnnotation
    private int age;
    @JavaDevAnnotation
    public Employee(String name, String lastName, int age) {
        super();
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }
    @JavaDevAnnotation
    public Employee() {
        super();
        // TODO Auto-generated constructor stub
    }
    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Employee [name=" + name + ", lastName=" + lastName + ", age=" + age + "]";
    }


}
