import java.lang.*;
import java.util.Scanner;
import java.util.Random;
import javap.Func;
public class LabelledBreak {
    public static void main(String s[])
    {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int temp, r, in;

        Func.clearScreen();
        System.out.println("Number Game");
        System.out.println("Rules:\nEnter 3 numbers which adds up to given aim\nWrong Inputs would restart the Level\nEnter 0 to exit the game\nThere are 10 levels\nDon't cheat with a calculator\nHave fun\n");
        System.out.println("Press Enter to start game :)");
        sc.nextLine();
        LEVELS:
        for(int i = 1; i <= 10; i++) {
            Func.clearScreen();
            temp = 0;
            r = random.nextInt(100);
            System.out.println("Level " + i + "\t\t\tCurrent Aim: " + r);
            RESTART: 
            for (int j = 1; j <= 3; j++) {
                System.out.print("Number " + j + ": ");
                in = sc.nextInt();
                
                if (in == 0) {
                    System.out.println("Okk, you bounced! Don't come again!\n");
                    break LEVELS;
                }
                else if (in < 0) {
                    System.out.println("I think, you got something small in mind\nTry again\n");
                    j--;
                    continue RESTART;
                }
                temp += in;
                if (temp > r) {
                    System.out.println("Sorry, your calculation flew so high! Play again!\n");
                    i--;
                    continue LEVELS;
                }
            }
            if (temp != r) {
                System.out.println("You got it wrong, let's try again\n");
                i--;
                continue LEVELS;
            }
            else {
                System.out.println("YOU are Sir Ramanujan my friend!\nYipee\n");
                if (i == 10) {
                    System.out.println("You won our hearts friend, go keep it up\n");
                }
                else {
                    System.out.println("Yay, its new level time\nPress Enter to go to next level");
                    sc.nextLine();
                    sc.nextLine();
                }
            }
        }
        sc.close();
    }
}