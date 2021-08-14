
import java.util.ArrayList;

public class Student {
    private final String studentName;
    private final ArrayList<Course> studentCourses;
    private boolean isCourseRegistered;
    private boolean isCourseDropped;

    //Constructor
    public Student(String studentName) {
        this.studentName = studentName;
        studentCourses = new ArrayList<>();
    }

    public String getStudentName() {
        return studentName;
    }

    public void registerCourse(Course course){
        int studentIndex =getStudentCourseIndex(course.getCourseName());
        if(studentIndex < 0){
            studentCourses.add(course);
            isCourseRegistered = true;
        }else{
            isCourseRegistered = false;
        }
    }
    public void dropCourse(Course course){
        int courseIndex = getStudentCourseIndex(course.getCourseName());

        if(courseIndex < 0){
            isCourseDropped = false;
        }else{
            Course courseToDrop = studentCourses.get(courseIndex);
            studentCourses.remove(courseToDrop);
            isCourseDropped = true;
        }
    }

    public void resetIsCourseRegistered(){
        isCourseRegistered = false;
    }
    public void resetIsCourseDropped(){
        isCourseDropped = false;
    }

    public void printStudentCourses(){
        System.out.println(studentName + " courses lists: ");
        int counter = 0;
        for (Course c: studentCourses) {
            counter++;
            System.out.println("\t" + counter + ". " + c.getCourseName());
        }
        System.out.println();
    }



    public boolean isCourseRegistered(){
        return isCourseRegistered;
    }
    public boolean isCourseDropped() {
        return isCourseDropped;
    }

    public int getStudentCourseIndex(String studentName){
        int counter = -1;
        for (Course c: studentCourses) {
            counter++;
            if(studentName.equals(c.getCourseName())){
                return counter;
            }
        }
        counter = -1;
        return counter;
    }

    public ArrayList<Course> getStudentCourses() {
        return studentCourses;
    }
}
