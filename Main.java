import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int userInput;                          //use to store main selection inputs.
        String studentNameInput;                //use to store student name inputs.
        String courseNameInput="";              //use to store course name inputs.
        int studentIndex;                       //use to store index of student.
        int courseIndex;                        //use to store index of course.
        boolean isRegistrationDone = false;     //flag for the main selection


        School sheridan = new School("Sheridan");
        System.out.println(sheridan.getSchoolName() + " Student Registration System");


        while (!isRegistrationDone){

            printSelection();
            userInput = scanner.nextInt();scanner.nextLine();


            switch (userInput){

                case 1://Add course

                    while (true){
                        System.out.println("Enter the name of the course you wish to add.");
                        System.out.print("> ");
                        courseNameInput = scanner.nextLine().toUpperCase();
                        sheridan.addCourse(courseNameInput);//add the course to the school.


                        if(sheridan.isCourseAdded()){
                            System.out.println(courseNameInput + " has been successfully added!");
                            sheridan.resetIsCourseAdded();
                            break;
                        }else{
                            System.out.println("Failed adding course!");
                            System.out.println("Course already on the list. Please try again");
                        }
                    }


                    sheridan.printCourses();
                    break;
                case 2://Remove Course
                    if(sheridan.getCourseIndex(courseNameInput) < 0){
                        System.out.println("There are no courses to be removed.");System.out.println("Please add a course first.");
                        break;
                    }
                    while (true){
                        sheridan.printCourses();
                        System.out.println("Enter the course you wish to remove.");
                        System.out.print("> ");
                        courseNameInput = scanner.nextLine().toUpperCase();
                        sheridan.removeCourse(courseNameInput);

                        //******************************************************************************
                        //Print result
                        if(sheridan.isCourseRemoved()){
                            System.out.println(courseNameInput + " has been successfully removed!");
                            sheridan.resetIsCourseRemoved();
                            break;
                        }else{
                            System.out.println("Failed removing a course!");
                            System.out.println("Course name can not be found.");
                        }
                    }
                    break;
                case 3://Add student
                    while (true){
                        System.out.println("Enter student name.");
                        System.out.print(">");
                        studentNameInput = scanner.nextLine().toUpperCase();
                        sheridan.addStudent(studentNameInput);

                        //******************************************************************************
                        //Print result
                        if(sheridan.isStudentAdded()){
                            System.out.println(studentNameInput + " has been successfully added to " + sheridan.getSchoolName() + " school.");
                            sheridan.resetIsStudentAdded();
                            break;
                        }else{
                            System.out.println("Failed adding a student.");
                            System.out.println(studentNameInput + " has been already added to " + sheridan.getSchoolName() + " school.");
                            System.out.println("Please try again.");
                        }
                    }
                    sheridan.printStudents();
                    break;
                case 4://Register student
                    //Validate if there are courses to register.
                    if(!canRegister(sheridan)){
                        break;
                    }

                    //Get and validate student name.

                    while (true){
                        sheridan.printStudents();
                        System.out.println("Enter student name: ");
                        System.out.print("> ");
                        studentNameInput = scanner.nextLine();
                        studentNameInput = studentNameInput.toUpperCase();
                        studentIndex = sheridan.getStudentIndex(studentNameInput);
                        if(studentIndex < 0 ){
                            System.out.println("Student can not be found. Please try again.");
                        }else{
                            break;
                        }
                    }
                    Student studentRegistering = sheridan.getStudents().get(studentIndex);
                    while (true){
                        sheridan.printCourses();
                        System.out.println("Enter course name.");
                        System.out.print("> ");
                        courseNameInput = scanner.nextLine();
                        courseNameInput = courseNameInput.toUpperCase();
                        courseIndex = sheridan.getCourseIndex(courseNameInput);

                        if(courseIndex < 0){
                            System.out.println("Course can not be found. Please try again.");
                        }else{
                            break;
                        }
                    }


                    Course  courseRegistering = sheridan.getCourses().get(courseIndex);

                    courseRegistering.registerStudent(studentRegistering);
                    studentRegistering.registerCourse(courseRegistering);
                    //******************************************************************************
                    //Print result
                    if(courseRegistering.isStudentRegistered() &&
                            studentRegistering.isCourseRegistered()){
                        System.out.println(studentRegistering.getStudentName() +
                                " has been successfully registered to " +
                                courseRegistering.getCourseName() + " course!");
                        //Reset the flag
                        courseRegistering.resetIsRegistered();
                        studentRegistering.resetIsCourseRegistered();
                        //Print to show if it is actually added to both objects.
                        courseRegistering.printCourseStudents();
                        studentRegistering.printStudentCourses();

                    }else{
                        System.out.println("Registration failed");
                        System.out.println(studentRegistering.getStudentName() + " has been already registered to this course.");
                    }
                    break;
                case 5://Drop course
                    //Validate if there are courses to register.
                    if(!canRegister(sheridan)){
                        break;
                    }


                    //Get and validate student name.
                    while (true){
                        sheridan.printStudents();
                        System.out.println("Enter student name: ");
                        System.out.print("> ");
                        studentNameInput = scanner.nextLine();
                        studentNameInput = studentNameInput.toUpperCase();
                        studentIndex = sheridan.getStudentIndex(studentNameInput);

                        if(studentIndex < 0 ){
                            System.out.println("Student can not be found. Please try again.");
                        }else{
                            break;
                        }
                    }

                    //Get the student.
                    Student studentDropping = sheridan.getStudents().get(studentIndex);

                    if(studentDropping.getStudentCourses().size() == 0){
                        System.out.println("Sorry this student do not have any registered courses.");
                        break;
                    }
                    //Get and validate student course
                    while (true){
                        studentDropping.printStudentCourses();
                        System.out.println("Enter course name.");
                        System.out.print("> ");
                        courseNameInput = scanner.nextLine();
                        courseNameInput = courseNameInput.toUpperCase();
                        courseIndex = studentDropping.getStudentCourseIndex(courseNameInput);
                        if(courseIndex < 0){
                            System.out.println("Course can not be found. Please try again.");
                        }else{
                            break;
                        }
                    }

                    //Get the course.
                    Course courseDropping = sheridan.getCourses().get(courseIndex);

                    courseDropping.dropStudent(studentDropping);
                    studentDropping.dropCourse(courseDropping);

                    if(courseDropping.isStudentDropped() && studentDropping.isCourseDropped()){
                        System.out.println(studentDropping.getStudentName() + " has been successfully dropped to "+ courseDropping.getCourseName() + " course!");
                        courseDropping.resetIsStudentDropped();
                        studentDropping.resetIsCourseDropped();
                        courseDropping.printCourseStudents();

                    }else{
                        System.out.println("Dropped failed");
                        System.out.println(studentDropping.getStudentName() + " is not registered to this course.");
                    }

                    break;
                case 6:
                    System.out.println("Goodbye!");
                    isRegistrationDone = true;
                    break;
                default:
                    System.out.println("Invalid input please try again.");
            }

        }
    }

    public static void printSelection(){
        System.out.println("Select one of the following");
        System.out.println("\t1. Add Course");
        System.out.println("\t2. Delete Course");
        System.out.println("\t3. Add Student");
        System.out.println("\t4. Register Student to Course");
        System.out.println("\t5. Drop Student From Course");
        System.out.println("\t6. Quit");
        System.out.print("> ");
    }
    public static boolean canRegister(School school){
        //Validate if there are courses to register.
        if(school.getCourses().size() == 0){
            System.out.println("Please register a course first.");
            return false;
        }
        //Validate if there are students to register.
        if(school.getStudents().size() == 0){
            System.out.println("Please register a student first.");
            return false;
        }

        return true;
    }



}
