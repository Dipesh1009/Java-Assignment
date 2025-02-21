class Person {
    String name;
    String phone;

    Person() {
        this.name = "Unknown";
        this.phone = "Not Available";
    }

    Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    static {
        System.out.println("A person has been created!");
    }
    
    public String toString() {
        return "\nName: " + name + "\nPhone No.: " + phone;
    }
}

class StudentTest extends Person {
    String course;
    int sID;
    
    StudentTest () {
        super();
        this.course = "NaN";
        this.sID = 00;
    }

    StudentTest(String name, String course, int sID, String phone) {
        super(name,phone);
        this.course = course;
        this.sID = sID;
    }

    {
        System.out.println("Student has been registered");
    }

    public String toString() {
        return super.toString() + "\nStudent ID: " + sID + "\nCourse: " + course; 
    }
}

class HeadStudent extends StudentTest {
    String roles;

    HeadStudent() {
        super();
        this.roles = "NaN";
    }

    HeadStudent(String name, String course, int sID, String phone, String roles) {
        super(name, course, sID, phone);
        this.roles = roles;
    }

    static {
        System.out.println("Student has been assigned a head role");
    }

    public String toString() {
        return super.toString() + "\nRole: " + roles;
    }
}

class InheritenceTest {
    public static void main(String[] args) {
        StudentTest s1 = new StudentTest("Rakesh", "MBA", 231, "3452632125");
        HeadStudent s2 = new HeadStudent("Suresh", "SE", 326, "2385233597", "Marketing Execution");
        StudentTest s3 = new StudentTest("Suresh", "SE", 326, "2385233597");
        Person s4 = new Person("KarKati", "7537426426");

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
    }    
}
