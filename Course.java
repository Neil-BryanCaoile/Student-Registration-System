import java.util.ArrayList;

public class Course {
    private final String courseName;
    private final ArrayList<Student> courseStudents;
    private boolean isStudentRegistered;
    private boolean isStudentDropped;

    //Constructor
    public Course(String courseName) {
        this.courseName = courseName;
        courseStudents = new ArrayList<>(20);
    }

    public String getCourseName() {
        return courseName;
    }

    public void printCourseStudents(){
        System.out.println("There are " + courseStudents.size() + "/20 student/s in this course.");
        System.out.println(courseName + " student lists: ");
        int counter = 0;
        for (Student s: courseStudents) {
            counter++;
            System.out.println("\t" + counter + ". " + s.getStudentName());
        }
        System.out.println();
    }

    public void resetIsRegistered(){
        isStudentRegistered = false;
    }
    public void resetIsStudentDropped(){
        isStudentDropped=false;
    }

    public void registerStudent(Student student){
        int studentIndex =getStudentIndex(student.getStudentName());
        if(studentIndex < 0){
            courseStudents.add(student);
            isStudentRegistered = true;
        }else{
            isStudentRegistered = false;
        }
    }

    public void dropStudent(Student student){
        int studentIndex = getStudentIndex(student.getStudentName());

        if(studentIndex < 0){
            isStudentDropped = false;
        }else{
            Student studentToDrop = courseStudents.get(studentIndex);
            courseStudents.remove(studentToDrop);
            isStudentDropped = true;
        }
    }

    public boolean isStudentRegistered(){
        return isStudentRegistered;
    }
    public boolean isStudentDropped(){
        return isStudentDropped;
    }

    public int getStudentIndex(String courseName){
        int counter = -1;
        for (Student s: courseStudents) {
            counter++;
            if(courseName.equals(s.getStudentName())){
                return counter;
            }
        }
        counter = -1;
        return counter;
    }
}
