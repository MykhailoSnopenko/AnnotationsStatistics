import java.util.List;

public class JavaDeveloper extends Programmer {
    private FrameWorks frameWork;
    @JavaDevAnnotation
    public JavaDeveloper(String name, String lastName, int age, int id, List<String> skills, FrameWorks frameWork) {
        super(name, lastName, age, id, skills);
        this.setFrameWork(frameWork);
    }

    public JavaDeveloper() {
        super();
        // TODO Auto-generated constructor stub
    }

    public FrameWorks getFrameWork() {
        return frameWork;
    }

    public void setFrameWork(FrameWorks frameWork) {
        this.frameWork = frameWork;
    }

    public int working(int start, int today ) {
        return today - start;
    }
}
