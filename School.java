
import java.util.ArrayList;

public class School {
    private final String schoolName;
    private final ArrayList<Course> courses;
    private final ArrayList<Student> students;
    private boolean isCourseAdded;
    private boolean isCourseRemoved;
    private boolean isStudentAdded;


    //Constructor.
    public School(String schoolName) {
        this.schoolName = schoolName;
        courses = new ArrayList<>();
        students = new ArrayList<>();
    }



    public void addCourse(String courseNameInput){
        if(getCourseIndex(courseNameInput) < 0){
            courses.add(new Course(courseNameInput));
            isCourseAdded = true;
        }else {
            isCourseAdded = false;

        }
    }
    public void addStudent(String studentName){
        //Go through the students array list and check if the name is duplicated
        int studentIndex = getStudentIndex(studentName);
        if(studentIndex < 0){
            students.add(new Student(studentName));
            isStudentAdded = true;
        }else{
            isStudentAdded = false;
        }
    }
    public void removeCourse(String courseName){
        int courseIndex = getCourseIndex(courseName);

        if(courseIndex < 0){
            isCourseRemoved = false;
        }else{
            Course courseToRemove = courses.get(courseIndex);
            courses.remove(courseToRemove);
            isCourseRemoved = true;
        }
    }

    public void printCourses(){
        System.out.println(schoolName + " courses lists: ");
        int counter = 0;
        for (Course c: courses) {
            counter++;
            System.out.println("\t" + counter + ". " + c.getCourseName());
        }
        System.out.println();
    }
    public void printStudents(){
        System.out.println(schoolName + " student lists: ");
        int counter = 0;
        for (Student s: students) {
            counter++;
            System.out.println("\t" + counter + ". " + s.getStudentName());
        }
        System.out.println();
    }

    public void resetIsCourseRemoved(){
        isCourseRemoved = false;
    }
    public void resetIsStudentAdded(){ isStudentAdded = false;}
    public void resetIsCourseAdded(){
        isCourseAdded = false;
    }

    public boolean isCourseAdded(){
        return isCourseAdded;
    }
    public boolean isCourseRemoved(){
        return isCourseRemoved;
    }
    public boolean isStudentAdded(){return isStudentAdded;}


    public int getStudentIndex(String courseName){
        int counter = -1;
        for (Student s: students) {
            counter++;
            if(courseName.equals(s.getStudentName())){
                return counter;
            }
        }
        counter = -1;
        return counter;
    }
    public int getCourseIndex(String courseName){
        int counter = -1;
        for (Course c: courses) {
            counter++;
            if(courseName.equals(c.getCourseName())){
                return counter;
            }
        }
        counter = -1;
        return counter;

    }


    public ArrayList<Course> getCourses() {return courses;}
    public ArrayList<Student> getStudents() { return students;}


    public String getSchoolName() {
        return schoolName;
    }
}
