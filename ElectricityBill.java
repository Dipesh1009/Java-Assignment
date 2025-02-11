import java.lang.*;
import java.util.Scanner;
import javap.Func;

class Consumer{
    String name;
    char connection_type, gender;
    int units;

    @Override
    public String toString() {
        return "Consumer Details\nName: " + this.name + "\nUnits Consumed: " + units;
    }
}

class ElectricityBoard {
    void getName(Consumer c, Scanner sc) {
        System.out.print("\nEnter User's Name: ");
        c.name = sc.nextLine();
    }

    void getGender(Consumer c, Scanner sc) {
        System.out.print("\nM for Male\tF for Female\nEnter Gender: "); 
        c.gender = sc.next().charAt(0);
    }

    void getArea(Consumer c, Scanner sc) {
        System.out.print("\nU for Urban Area\tR for Rural area\nEnter Area: "); 
        c.connection_type = sc.next().charAt(0);
    }

    void getUnits(Consumer c, Scanner sc) {
        System.out.print("\nEnter units consumed in a month: ");
        c.units = sc.nextInt();
    }
    void getBill() {
        float bill = 0;
        Consumer c = new Consumer();
        Scanner sc = new Scanner(System.in);
        getName(c, sc);
        getGender(c, sc);
        getArea(c, sc);
        getUnits(c, sc);
        switch (c.connection_type) {
            case 'U':
            case 'u':
                switch (c.gender) {
                    case 'M':
                    case 'm':
                        
                        if (c.units < 100) {
                            bill += c.units * 0.20;
                        } else if (c.units >= 100 && c.units < 200) {
                            bill += c.units;
                        } else if (c.units >= 200 && c.units < 500) {
                            bill += (c.units * 5) + 100;
                        } else {
                            bill += (c.units * 10) + 500;
                        }
                        break;
                    case 'F':
                    case 'f':
                        
                        if (c.units < 100) {
                            
                        } else if (c.units >= 100 && c.units < 200) {
                            bill += c.units * 0.20;
                        } else if (c.units >= 200 && c.units < 500) {
                            bill += (c.units * 2) + 50;
                        } else {
                            bill += (c.units * 5) + 200;
                        }
                        break;
                    default: 
                        System.out.println("Invalid Gender Input");
                        break;
                }
                break;
            case 'R':
            case 'r':
                switch (c.gender) {
                    case 'M':
                    case 'm':
                        
                        if (c.units < 100) {
                            bill += c.units * 0.10;
                        } else if (c.units >= 100 && c.units < 200) {
                            bill += c.units * 0.75;
                        } else if (c.units >= 200 && c.units < 500) {
                            bill += (c.units * 3) + 25;
                        } else {
                            bill += (c.units * 7) + 150;
                        }
                        break;
                    case 'F':
                    case 'f':
                        
                        if (c.units < 100) {

                        } else if (c.units >= 100 && c.units < 200) {
                            bill += c.units * 0.20;
                        } else if (c.units >= 200 && c.units < 500) {
                            bill += c.units * 2;
                        } else {
                            bill += (c.units * 5) + 100;
                        }
                        break;
                    default: 
                        System.out.println("Invalid Gender Input");
                        break;
                }
                break;


            default: 
                System.out.println("Invalid Input for Area");
                break;
        }
        Func.clearScreen();
        System.out.println("Electricity Bill\n" + c);
        System.out.println("Bill for this month is: " + bill + " Rs.");
        sc.close();
    }
}
public class ElectricityBill {
    public static void main(String[] args) {
        ElectricityBoard e = new ElectricityBoard();
        e.getBill();
    }
}
