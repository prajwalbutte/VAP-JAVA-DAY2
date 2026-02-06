public class StudentDemo {

}

class Student {
    private int id;
    private String name;
    private String branch;
    private int year;

    public Student(int id, String name, String branch, int year) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.year = year;
    }

   
public int getId(){
    return id;
}
public String getName(){
    return name;
}
public String getBranch(){
    return branch;
}
public int getYear(){
    return year;
}

public void setId(int id){
    this.id = id;
}
public void setName(String name){
    this.name = name;
}
public void setBranch(String branch){
    this.branch = branch;
}
public void setYear(int year){
    this.year = year;
}

public void display(){
   System.out.printf("%d | %-15s | %-10s | %-4d%n", id, name, branch, year);
}
}