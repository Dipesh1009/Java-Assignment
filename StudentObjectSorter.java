class Student {
    String name;
    int age;
    int rollNo;
    
    public Student(String name, int age, int rollNo) {
        this.name = name;
        this.age = age;
        this.rollNo = rollNo;
    }
    
    public void display() {
        System.out.println("Name: " + name + ", Age: " + age + ", Roll No: " + rollNo);
    }
    
    static class Sorter {
        static void byName(Student[] students) {
            for (int i = 0; i < students.length - 1; i++) {
                for (int j = 0; j < students.length - i - 1; j++) {
                    if (compareStrings(students[j].name, students[j + 1].name) > 0) {
                        Student temp = students[j];
                        students[j] = students[j + 1];
                        students[j + 1] = temp;
                    }
                }
            }
        }
        
        static void byRollNo(Student[] students) {
            for (int i = 0; i < students.length - 1; i++) {
                for (int j = 0; j < students.length - i - 1; j++) {
                    if (students[j].rollNo > students[j + 1].rollNo) {
                        Student temp = students[j];
                        students[j] = students[j + 1];
                        students[j + 1] = temp;
                    }
                }
            }
        }
        
        static void byAge(Student[] students) {
            for (int i = 0; i < students.length - 1; i++) {
                for (int j = 0; j < students.length - i - 1; j++) {
                    if (students[j].age > students[j + 1].age) {
                        Student temp = students[j];
                        students[j] = students[j + 1];
                        students[j + 1] = temp;
                    }
                }
            }
        }

        static int compareStrings(String str1, String str2) {
            str1.toLowerCase();
            str2.toLowerCase();
            int minLength = Math.min(str1.length(), str2.length());
            for (int i = 0; i < minLength; i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    return str1.charAt(i) - str2.charAt(i);
                }
            }
            return str1.length() - str2.length();
        }

    }
    
    public static void main(String[] args) {
        Student[] students = {
            new Student("Alice", 22, 103),
            new Student("Alic", 20, 101),
            new Student("Charlie", 21, 102)
        };
        
        System.out.println("Sorting by Name:");
        Sorter.byName(students);
        for (Student s : students) s.display();
        
        System.out.println("\nSorting by Roll No:");
        Sorter.byRollNo(students);
        for (Student s : students) s.display();
        
        System.out.println("\nSorting by Age:");
        Sorter.byAge(students);
        for (Student s : students) s.display();
    }
}
    

