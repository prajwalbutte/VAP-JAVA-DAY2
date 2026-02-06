import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StudentManagement {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        loadFromFile();

        boolean runMenu = true;
        while (runMenu) {

            System.out.println("STUDENT MANAGEMENT SYSTEM ");

            System.out.println("\n===== MENU =====");
            System.out.println("1.Add a Student");
            System.out.println("2.View all Students");
            System.out.println("3.Search by ID");
            System.out.println("4.Update Student");
            System.out.println("5.Delete Student");
            System.out.println("6.Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    saveToFile();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    searchByID();
                    break;
                case 4:
                    updateStudent();
                    saveToFile();
                    break;
                case 5:
                    deleteStudent();
                    saveToFile();
                    break;
                case 6:
                    runMenu = false;
                    System.out.println("Exited....Data has been saved");
                    break;

                default:
                    System.out.println("Enter valid choice!");
                    break;

            }
        }
    }

    static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Students Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Branch: ");
        String branch = sc.nextLine();

        System.out.print("Enter year: ");
        int year = sc.nextInt();

        Student s = new Student(id, name, branch, year);
        students.add(s);
        System.out.println("Student added successfully!");
    }

    static void viewAllStudents() {
        System.out.println("All Students");
        if (students.isEmpty()) {
            System.out.println("No students found!");
        }
        System.out.println("ID | Name            | Branch | year");
        System.out.println("-----------------------------------------");
        for (Student s : students) {
            s.display();
        }

    }

    static void searchByID() {
        System.out.println("/n----Search Student----");
        System.out.println("Enter ID to search:");
        int id = sc.nextInt();
        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println("Student found!");
                s.display();
                return;
            }
           
        } System.out.println("Student with id " + id + "not found");

    }

    static void updateStudent() {
        System.out.println("/n---Update Student---");
        System.out.println("Enter id to update");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.getId() == id) {
                sc.nextLine(); 
                System.out.print("New Name (press Enter to skip): ");
                String name = sc.nextLine();
                if (!name.isEmpty())
                    s.setName(name);

                System.out.print("New Branch (press Enter to skip): ");
                String branch = sc.nextLine();
                if (!branch.isEmpty())
                    s.setBranch(branch);

                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");

    }

    static void deleteStudent() {
        System.out.println("\n--- Delete Student ---");
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        boolean removed = students.removeIf(e -> e.getId() == id);

        if (removed) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    static void saveToFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Students.txt"));
            for (Student s : students) {
                bw.write(s.getId() + "," + s.getName() + "," + s.getBranch() + "," + s.getYear());
                bw.newLine();

            }
            bw.close();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());

        }

    }

    static void loadFromFile() {
        try {
            File file = new File("Students.txt");
            if (!file.exists())
                return;

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null){
                String[] parts = line.split(",");
                students.add(new Student(Integer.parseInt(parts[0]), parts[1], parts[2],Integer.parseInt(parts[3])));

            }
            br.close();
        }catch(IOException e){}
        

    }

}
