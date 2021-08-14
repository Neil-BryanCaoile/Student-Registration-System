import java.util.ArrayList;

abstract class StudentRegistration {
    private String name;
    private boolean isAdded = false;
    private boolean isRemoved = false;
    private ArrayList<Object> objects = new ArrayList<>();

    public StudentRegistration(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public boolean isAdded() {
        return isAdded;
    }
    public boolean isRemoved() {
        return isRemoved;
    }
    public ArrayList<Object> getObjects() {
        return objects;
    }

}
