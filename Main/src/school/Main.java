package school;
import school.model.*;
import school.controller.SchoolService;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SchoolService schoolService = new SchoolService();

        /* ask for school name*/
        System.out.print("School name: ");
        String schoolName = scanner.nextLine();

        /* create teachers*/
        System.out.print("How many teachers? ");
        int nbTeachers = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < nbTeachers; i++){
            System.out.println("Teacher " + (i + 1));
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Salary: ");
            double salary = Double.parseDouble(scanner.nextLine());

            Teacher teacher = new Teacher(name, salary);
            schoolService.addTeacher(teacher);
            System.out.println("Teacher " + teacher.getName() + " created with ID: " + teacher.getTeacherId());
        }

        /* create courses without teacher*/
        System.out.print("How many courses? ");
        int nbCourses = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < nbCourses; i++){
            System.out.println("Course " + (i+1));
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Price: ");
            double price = Double.parseDouble(scanner.nextLine());

            Course course = new Course(name, price);
            schoolService.addCourse(course);
            System.out.println("Course " + course.getName() + " created with ID: " + course.getCourseId());
        }

        /* create students without course*/
        System.out.print("How many students? ");
        int nbStudents = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < nbStudents; i++){
            System.out.println("Student " + (i+1));
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Address: ");
            String address = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();

            Student student = new Student(name, address, email);
            schoolService.addStudent(student);
            System.out.println("Student " + student.getName() + " created with ID: " + student.getStudentId());
        }

        /* menu*/
        System.out.println("\nChoose an option (ENROLL, ASSIGN, SHOW, LOOKUP, SHOWPROFIT, EXIT): ");
        while (true){
            System.out.print("\nCommand > ");
            String input = scanner.nextLine().trim();
            String[] parts = input.split(" ");

            try{
                switch (parts[0].toUpperCase()) {
                    case "ENROLL":
                        if (parts.length < 3) {
                            System.out.println("Usage: ENROLL [STUDENT_ID] [COURSE_ID]");
                            break;
                        }
                        schoolService.enrollStudent(parts[1], parts[2]);
                        break;
                    case "ASSIGN":
                        if (parts.length < 3) {
                            System.out.println("Usage: ASSIGN [TEACHER_ID] [COURSE_ID]");
                            break;
                        }
                        schoolService.assignTeacher(parts[1], parts[2]);
                        break;
                    case "SHOW":
                        schoolService.handleShowCommand(parts);
                        break;
                    case "LOOKUP":
                        schoolService.handleLookupCommand(parts);
                        break;
                    case "SHOWPROFIT":
                        double profit = schoolService.calculateProfit();
                        System.out.printf("Total profit: %.2f€\n", profit);
                        break;
                    case "EXIT":
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Unknown command.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}