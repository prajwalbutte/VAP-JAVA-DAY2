import java.util.ArrayList;
public class StudentArrayList {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(101, "Prajwal", "Computer", 2026));
        students.add(new Student(101, "Prajwal", "Computer", 2026));
        students.add(new Student(101, "Prajwal", "Computer", 2026));
        students.add(new Student(101, "Prajwal", "Computer", 2026));

        System.out.println("All Students: ");
        System.out.println("ID | Name              | Branch      | Salary");
        System.out.println("--------------------------------------------------------");
        for(Student s : students){
            s.display();
        }
    }

    
    
    
    
}
