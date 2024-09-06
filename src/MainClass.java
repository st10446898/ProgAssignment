import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nStudent Application Menu:");
            System.out.println("1. Save Student");
            System.out.println("2. Search Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Student Report");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Student.saveStudent(studentList);
                    break;
                case 2:
                    Student.searchStudent(studentList);
                    break;
                case 3:
                    Student.deleteStudent(studentList);
                    break;
                case 4:
                    Student.studentReport(studentList);
                    break;
                case 5:
                    Student.exitStudentApplication();
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
        scanner.close();
    }
}

