import java.util.Scanner;
import javap.Func;

class Candidate {
    String name;
    int votes = 0;

    Candidate() {}

    Candidate(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name + "\t\t" + this.votes + "\n";
    }
}

class Election {
    Candidate[] cands = {
        new Candidate("A"),
        new Candidate("B"),
        new Candidate("C")
    };
    int voteCount = 0, flag;
    
    void giveVote(Scanner sc) {
        voteCount++;
        
        Func.clearScreen();
        System.out.println("Candidate List:\n"); 
        for(int i = 0; i < 3; i++) {
            System.out.println((i+1) + ". "+ cands[i].name + "\n");
        }
        System.out.println("Enter serial number of Candidate to vote: ");

        byte vote = sc.nextByte();
        vote--;
        if (vote >= cands.length) {
            System.out.println("Invalid Choice");
            return;
        }
        else if ((voteCount % 3 == 0) || (voteCount % 5 == 0) || (voteCount % 7 == 0)) {
            cands[1].votes++;
        }
        else {
            cands[vote].votes++;
        }

        System.out.println("\nYour votes has been given to " + cands[vote].name);
        System.out.println("Press enter to proceed");
        sc.nextLine();
        sc.nextLine();
    }

    void showCandidate(Scanner sc) {
        Func.clearScreen();
        System.out.println("Candidate List:\n"); 
        for(int i = 0; i < 3; i++) {
            System.out.println((i+1) + ". "+ cands[i].name + "\n");
        }
        System.out.println("Enter serial number of Candidate to see: ");

        byte vote = sc.nextByte();
        vote--;
        System.out.println("Candidate\tVotes\n");
        System.out.println(cands[vote]);
        System.out.println("Press enter to proceed");
        sc.nextLine();
        sc.nextLine();
    }

    void showResult(Scanner sc) {
        Func.clearScreen();
        System.out.println("Candidate\tVotes\n");
        for(Candidate c: cands) {
            System.out.println(c);
        }
        System.out.println("Press enter to proceed");
        sc.nextLine();
        sc.nextLine();
    }

    void runDashboard(Scanner sc) {
        do {
            this.flag = 1;
            Func.clearScreen();
            System.out.println("Election 2025\t\t\t\t\tTotal Vote Count:" + voteCount + "\n\n1. Give Vote\n2. Show Candidate\n3. Show Results\n0. Exit\n");
            this.flag = sc.nextInt();
            switch(flag) {
                case 1: 
                    giveVote(sc);
                    break;
                case 2: 
                    showCandidate(sc);
                    break;
                case 3:
                    showResult(sc);
                    break;
                case 0:
                    showResult(sc);
                    break;
                default: 
                    System.out.println("Invalid Input");
                    System.out.println("Press enter to proceed");
                    sc.nextLine();
                    sc.nextLine();
            }
        }   while (flag != 0);
    }
    

}

public class Voting {
        public static void main(String[] args) {
            Scanner sc = new Scanner (System.in);
            Election e = new Election();
            e.runDashboard(sc);
            sc.close();
        }
}

