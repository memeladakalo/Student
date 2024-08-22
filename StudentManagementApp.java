import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementApp {
    private ArrayList<Student> students = new ArrayList<>();
    
    public ArrayList<Student> getStudents(){
    
        return null;
    
    }
            
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StudentManagementApp app = new StudentManagementApp();
        app.run();
    }

    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = validateChoice(scanner.nextLine());
            switch (choice) {
                case 1:
                    captureStudent();
                    break;
                case 2:
                    searchStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    studentReport();
                    break;
                case 5:
                    exitApplication();
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\nStudent Management System");
        System.out.println("1. Capture New Student");
        System.out.println("2. Search Student");
        System.out.println("3. Delete Student");
        System.out.println("4. View Student Report");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private int validateChoice(String choiceStr) {
        try {
            return Integer.parseInt(choiceStr);
        } catch (NumberFormatException e) {
            return -1; // return an invalid choice if parsing fails
        }
    }

    private void captureStudent() {
        
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        int age = 0;
        while (true) {
            
            System.out.print("Enter Student Age (>= 16): ");
            
            String ageStr = scanner.nextLine();
            try {
                age = Integer.parseInt(ageStr);
                if (age >= 16) break;
                else 
                    System.out.println("------------------------------------------");
                    System.out.println("Age must be 16 and older. Please try again.");
                    System.out.println("------------------------------------------");
            } catch (NumberFormatException e) {
                System.out.println("-----------------------------------------");
                System.out.println("Invalid input. Enter a valid age (>= 16).");
                System.out.println("-----------------------------------------");
            }
        }

        Student student = new Student(id, name, age);
        students.add(student);
        System.out.println("---------------------------------------------");
        System.out.println("Student details have been successfully saved.");
        System.out.println("---------------------------------------------");
    }

    private void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        String id = scanner.nextLine();

        for (Student student : students) {
            if (student.getId().equals(id)) {
                System.out.println("-----------------------");
                System.out.println("Student found: " + student);
                System.out.println("-----------------------");
                return;
            }
        }
        System.out.println("-------------------------------------------");
        System.out.println("Student with ID " + id + " cannot be located.");
        System.out.println("-------------------------------------------");
    }

    private void deleteStudent() {
        System.out.println("--------------------------");
        System.out.print("Enter Student ID to delete: ");
        System.out.println("--------------------------");
        String id = scanner.nextLine();

        for (Student student : students) {
            if (student.getId().equals(id)) {
                System.out.println("------------------------------------------------------");
                System.out.print("Are you sure you want to delete this student? (yes/no): ");
                System.out.println("------------------------------------------------------");
                String confirmation = scanner.nextLine();
                if (confirmation.equalsIgnoreCase("yes")) {
                    students.remove(student);
                    System.out.println("---------------------------");
                    System.out.println("Student has been deleted.");
                    System.out.println("---------------------------");
                } else {
                    System.out.println("-------------------");
                    System.out.println("Deletion cancelled.");
                    System.out.println("-------------------");
                }
                return;
            }
        }System.out.println("------------------------------------------");
        System.out.println("Student with ID " + id + " cannot be located.");
        System.out.println("-------------------------------------------");
    }

    private void studentReport() {
        if (students.isEmpty()) {
            System.out.println("-----------------------------");
            System.out.println("No student records available.");
            System.out.println("-----------------------------");
        } else {
            System.out.println("---------------");
            System.out.println("Student Report:");
            System.out.println("---------------");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    private void exitApplication() {
        System.out.println("------------------------------");
        System.out.println("Existing application. Goodbye!");
        System.out.println("------------------------------");
    }
}

