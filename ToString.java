import java.lang.*;

class Student {
    String name;
    int roll;

    Student() {}

    Student(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }
    
    public String toString() {
        return "Name: " + this.name + "\tRoll No.: " + this.roll;
    }
}


public class ToString {

    public static void main(String[] args) {
        Student s1 = new Student("Suresh",25);
        Student s2 = new Student("Kamalesh",18);
        Student s3 = new Student("Priya",4);
        System.out.println(s1 + "\n" + s2 + "\n" + s3);
    }
    
}
