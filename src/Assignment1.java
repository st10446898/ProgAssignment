import java.util.ArrayList;
import java.util.Scanner;

public class Assignment1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>(); // ArrayList to store students

        while (true) {  // Main loop for running the application
            System.out.println("*************************************");
            System.out.println("*      STUDENT MANAGEMENT APP       *");
            System.out.println("*************************************");
            System.out.println("Enter (1) to launch menu or any other key to exit");

            String input = scanner.nextLine();
            if (!input.equals("1")) {
                System.out.println("Exiting application...");
                break; // Exit the main loop to stop the program
            }

            while (true) {  // Inner loop for the menu system
                // Display the menu
                System.out.println("Please select one of the following menu items:");
                System.out.println("(1) Capture a new student.");
                System.out.println("(2) Search for a student.");
                System.out.println("(3) Delete a student.");
                System.out.println("(4) Print student report.");
                System.out.println("(5) Exit Application.");

                // Get user choice
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character after input

                switch (choice) {
                    case 1:
                        System.out.println("Capturing new student...");
                        Student newStudent = captureStudentDetails(scanner); // Capture student details
                        students.add(newStudent); // Add student to ArrayList
                        System.out.println("Student information captured successfully!");
                        break;
                    case 2:
                        System.out.println("Searching for a student...");
                        searchStudent(scanner, students); // Call the search function
                        break;
                    case 3:
                        System.out.println("Deleting a student...");
                        deleteStudent(scanner, students); // Call the delete function
                        break;
                    case 4:
                        System.out.println("Printing student report...");
                        printStudentReport(students); // Call the print report function
                        break;
                    case 5:
                        System.out.println("Exiting application...");
                        return; // Exit the program
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }
            }
        }
        scanner.close(); // Close the scanner
    }

    public static Student captureStudentDetails(Scanner scanner) {
        // Capture student details with validation for age and ID
        System.out.println("CAPTURE A NEW STUDENT");
        System.out.println("************************");

        int age;
        do {
            System.out.print("Enter the student age (minimum 16 years): ");
            while (!scanner.hasNextInt()) {
                System.out.println("You have entered an incorrect student age! Please re-enter a valid number.");
                scanner.next(); // Clear invalid input
            }
            age = scanner.nextInt();
            scanner.nextLine(); // Consume the newline after int input
        } while (age < 16);

        System.out.print("Enter the student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline after int input

        System.out.print("Enter the student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the student email: ");
        String email = scanner.nextLine();

        System.out.print("Enter the student course: ");
        String course = scanner.nextLine();

        return new Student(id, name, age, email, course); // Create and return Student object
    }

    public static void searchStudent(Scanner scanner, ArrayList<Student> students) {
        System.out.print("Enter the student ID to search: ");
        int searchId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        boolean studentFound = false;
        System.out.println("---------------------------------------");

        for (Student student : students) {
            if (student.id == searchId) {
                // If student is found, display their details
                System.out.println("STUDENT ID: " + student.id);
                System.out.println("STUDENT NAME: " + student.name);
                System.out.println("STUDENT AGE: " + student.age);
                System.out.println("STUDENT EMAIL: " + student.email);
                System.out.println("STUDENT COURSE: " + student.course);
                System.out.println("---------------------------------------");
                studentFound = true;
                break;
            }
        }

        if (!studentFound) {
            // If student is not found, display an error message
            System.out.println("Student with ID: " + searchId + " was not found!");
            System.out.println("---------------------------------------");
        }
    }

    public static void deleteStudent(Scanner scanner, ArrayList<Student> students) {
        System.out.print("Enter the student ID to delete: ");
        int searchId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        int studentIndex = -1; // Initialize to -1 to indicate student not found
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).id == searchId) {
                studentIndex = i;
                break;
            }
        }

        if (studentIndex != -1) {
            System.out.println("---------------------------------------");
            System.out.println("Student found: ");
            System.out.println("STUDENT ID: " + students.get(studentIndex).id);
            System.out.println("STUDENT NAME: " + students.get(studentIndex).name);
            System.out.println("Are you sure you want to delete student " + searchId + " from the system? Enter Yes (y) to confirm:");
            String confirmation = scanner.nextLine().toLowerCase(); // Convert to lowercase for case-insensitive comparison

            if (confirmation.equals("y")) {
                students.remove(studentIndex);
                System.out.println("-------------------------------------------");
                System.out.println("Student with Student ID: " + searchId + " WAS deleted!");
                System.out.println("-------------------------------------------");
            } else {
                System.out.println("Student deletion canceled.");
            }
        } else {
            System.out.println("Student with ID: " + searchId + " was not found!");
            System.out.println("---------------------------------------");
        }
    }

    public static void printStudentReport(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("STUDENT REPORT");
            System.out.println("------------------------------------------------");

            // Loop through each student in the list
            for (int i = 0; i < students.size(); i++) {
                Student student = students.get(i);

                // Display the student information as required
                System.out.println("STUDENT " + (i + 1));
                System.out.println("------------------------------------------------");
                System.out.println("STUDENT ID: " + student.id);
                System.out.println("STUDENT NAME: " + student.name);
                System.out.println("STUDENT AGE: " + student.age);
                System.out.println("STUDENT EMAIL: " + student.email);
                System.out.println("STUDENT COURSE: " + student.course);
                System.out.println("------------------------------------------------");
            }
        }
    }
}

class Student {
    int id;
    String name;
    int age;
    String email;
    String course;

    public Student(int id, String name, int age, String email, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    public static void saveStudent(ArrayList<Student> studentList) {
    }

    public static void searchStudent(ArrayList<Student> studentList) {
    }

    public static void deleteStudent(ArrayList<Student> studentList) {
    }

    public static void studentReport(ArrayList<Student> studentList) {
    }

    public static void exitStudentApplication() {
    }
}
