import java.util.Scanner;


//!! modif class and method names


public class Main {
    public static void main(String[] args) {

    }
        Scanner scanner = new Scanner (System.in);
        SchoolService schoolService = New SchoolService();

        /* ask for school name*/
        System.out.print("School name: ");
        String schoolName = scanner.nextLine();

        /* create teachers*/
        System.out.print("How many teachers? ");
        int nbTeachers = Integer.parseInt(scanner.nextLine();

        for (int i = 0; i < nbTeachers; i++){
            System.out.println("Teacher " + (i + 1));
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Salary: ");
            double salary = Double.parseDouble(scanner.nextLine());

            Teacher teacher = new Teacher(name, salary);
            schoolService.addTeacher(teacher);
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
        }

        /* menu*/

        while (true){
            System.out.print("Command > ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");

            try{
                System.out.println("Commande reçue : " + Arrays.toString(parts));//pour verifier les arguments
                switch (parts[0]) {
                    case "ENROLL":
                        schoolService.enrollStudent(parts[1], parts[2]);
                        break;
                    case "ASSIGN":
                        schoolService.assignTeacher(parts[1], parts[2]);
                        break;
                    case "SHOW":
                        //remplir
                        break;
                    case "LOOKUP":
                        //remplir
                        break;
                    case "EXIT":
                        return; // Sortie propre
                    default:
                        System.out.println("Unknown command");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
}