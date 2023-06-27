import java.util.List;

public class Programmer extends Employee{
    private int id;
    private List <String> skills;

    @JavaDevAnnotation
    public Programmer(String name, String lastName, int age, int id, List<String> skills) {
        super(name, lastName, age);
        this.id = id;
        this.skills = skills;
    }
    @JavaDevAnnotation
    public Programmer() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Programmer(String name, String lastName, int age) {
        super(name, lastName, age);
        // TODO Auto-generated constructor stub
    }
    @ProgrammerAnnotation
    public int getId() {
        return id;
    }
    public List<String> getSkills() {
        return skills;
    }
    @ProgrammerAnnotation
    public void setId(int id) {
        this.id = id;
    }
    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
    @Override
    public String toString() {
        return "Programmer [id=" + id + ", skills=" + skills + "]";
    }
    @ProgrammerAnnotation
    public void greatings() {
        System.out.println("Hi, I'm proggramer");
    }
    @ProgrammerAnnotation
    public void experience() {
        System.out.println("I'm jun proggramer");
    }


}
