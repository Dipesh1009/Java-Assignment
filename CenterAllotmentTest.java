import java.util.Scanner;
import javap.Func;

class Candidate {
    String name;
    String university;
    String college;
    String rollNo;
    String subject;
    String uniqueID = null;
    String center = null;

    Candidate() {}

    Candidate(String name, String college, String subject, String university, String rollNo) {
        this.name = name;
        this.college = college;
        this.subject = subject;
        this.university = university;
        this.rollNo = rollNo;
    }

    void setName(String name) {
        this.name = name;
    }

    void setCollege(String college) {
        this.college = college;
    }

    void setUniversity(String university) {
        this.university = university;
    }    

    void setSubject(String subject) {
        this.subject = subject;
    }

    void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }
    
    void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    void setCenter(String center) {
        this.center = center;
    }

    public String toString() {
        if (this.uniqueID.charAt(0) == 'r') {
            return "\n---- Candidate Details ----\nName: " + this.name + "\nSubject: " + this.subject + "\nCollege: " + this.college + "\nuniversity: " + this.university + "\nRoll Number: " + this.rollNo + "\nRegistration ID: " + this.uniqueID + "\nCenter: Not alloted.";    
        } 
        else {
            return "\n---- Candidate Details ----\nName: " + this.name + "\nSubject: " + this.subject + "\nCollege: " + this.college +     "\nuniversity: " + this.university + "\nRoll Number: " + this.rollNo + "\nUnique ID: " + this.  uniqueID + "\nCenter: " + this.center;
        }
    }
}

class Center {
    String name;
    String centerID;
    int noOfSeats;
    int seatsAlloted;

    Center() {

    }

    Center(String name, String centerID, int noOfSeats) {
        this.name = name;
        this.centerID = centerID;
        this.noOfSeats = noOfSeats;
    }

    int remainingSeats() {
        return (this.noOfSeats-this.seatsAlloted);
    }
    
    public void displayCenter() {
        System.out.println("Name of Center: " + this.name + "\tCenter ID: " + this.centerID);
    }

    public String toString(){
        return "Name of Center: " + this.name + "\tCenter ID: " + this.centerID + "\nNumber of Seats: " + this.noOfSeats + "\tRemaining Seats: " + this.remainingSeats();
    }
}

class CenterManagement {
    Center[] centerList = {
        new Center("MK Gandhi College", "RH-0", 5),
        new Center("Vaishnav Institute", "RH-1", 7),
        new Center("Acropolis College", "RH-2", 8),
        new Center("Medicaps College", "RH-3", 3),
        new Center("Rajkumar College", "RH-4", 5)
    };
    int totalSeats = 0;
    Candidate[] candidateList;
    int candListIndex = -1;

    
    CenterManagement(){
        for (Center center : centerList) {
            totalSeats += center.noOfSeats;
        }
        candidateList = new Candidate[totalSeats];
    }

    boolean isSeatAvailable() {
        if (totalSeats > 0) {
            return true;
        }
        return false;
    }

    String generateIndex (String s_id) {
        String indx = "";
        if (s_id.charAt(0) == 'r') {
            for (int i = 6; i < s_id.length(); i++) {
                indx += s_id.charAt(i);
            }
            return indx;
        } 
        else if (Character.isDigit(s_id.charAt(0))) {
            for (int i = 5; i < s_id.length(); i++) {
                indx += s_id.charAt(i);
            }
            return indx;
        }
        return null;
    }

    String uniqueIDGenerator(Center center, Candidate cand) {
        String id = "";
        for (int i = 0; i < cand.rollNo.length(); i++) {
            id += cand.rollNo.charAt(i);
        }
        id += center.centerID.charAt(3);
        id += cand.uniqueID.charAt(6);
        return id;
    }

    String uniqueRegisterIdGenerator(Candidate cand) {
        String id = "rn";
        for (int i = 0; i < cand.rollNo.length(); i++) {
            id += cand.rollNo.charAt(i);
        }
        id += (candListIndex + 1);
        return id;
    }

    boolean verifyRollNo(Candidate cand) {
        if (candListIndex >= 0) {
            for (int i = 0; i <= candListIndex; i++) {
                if(cand.rollNo.equals(candidateList[i].rollNo)) {
                    System.out.println("\nRoll number already registered, Enter correct details\n");
                    return false;
                }
            }
        }
        return true;
    }

    Candidate verifyRegistrationID(String r_id) {
        String indxString = generateIndex(r_id);
        if (indxString != null) {
            int indx = Integer.parseInt(indxString);
            if (candidateList[indx] == null) {
                System.out.println("Given ID is not recognized");
                return null;
            }
            if (candidateList[indx].uniqueID.equals(r_id)) {
                if (candidateList[indx].uniqueID.charAt(0) == 'r') {
                    return candidateList[indx];
                }
                else {
                    System.out.println("Centre is already alloted\n" + candidateList[indx]);
                    return null;
                }
            }
            else {
                System.out.println("Given ID is not recognized");
                return null;
            }
        }
        else {
            System.out.println("Given ID is not recognized");
            return null;
        }
    }
    
    boolean candidateRegistration(Candidate cand) {
        if (!verifyRollNo(cand)){
            return false;
        }
        cand.uniqueID = uniqueRegisterIdGenerator(cand);
        candidateList[++candListIndex] = cand;

        return true;
    }

    boolean verifyCenters(String[] centerListChoice) {
        int flag = 0;
        CENTER_CHECK:for (String center : centerListChoice) {
            for (Center c : this.centerList) {
                if (center.equals(c.centerID)) {
                    flag++; 
                    continue CENTER_CHECK;
                }
            }
        }
        if (flag != 3) {
            return false;
        }
        return true;
    }

    boolean centerAllotment(Candidate cand, String[] center) {
        Center allotedCenter = null;
        CenterValidity:
        for (String c : center) {
            for (Center list : centerList) {
                if (c.equals(list.centerID) && list.seatsAlloted < list.noOfSeats) {
                    allotedCenter = list;
                    allotedCenter.seatsAlloted++;
                    break CenterValidity;
                }
            }
        }
        if (allotedCenter == null) {
            System.out.println("Selected centers can not be alloted.");
            return false;
        }
        cand.center = allotedCenter.centerID;
        cand.uniqueID = uniqueIDGenerator(allotedCenter, cand);
        totalSeats--;
        return true;
    }

    void showCenterDetail() {
        System.out.println("--------- Available Centre Details ---------");
        for (Center center : centerList) {
            System.out.println(center);
        }
    } 

    void showCenters() {
        System.out.println("--------- Available Centres ---------");
        for (Center center : centerList) {
            center.displayCenter();
        }
    }

    void showAllCandidates() {
        for (int i = 0; i <= candListIndex; i++) {
            System.out.println(candidateList[i]);
        }
    }
}

class CenterAllotment extends CenterManagement {

    void candidateRegistrationProcess(Scanner sc) {
        if (!isSeatAvailable() || candListIndex == totalSeats) {
            System.out.println("Registrations are full");
            return;
        }

        Candidate cand = new Candidate();
        String temp;
        boolean flag = true;
        do {

            System.out.println("--- Student Registration ---");
            System.out.println("Enter the Corresponding details below to register yourself for Center choice");
            sc.nextLine();
            System.out.print("\nEnter your name: ");
            temp = sc.nextLine();
            cand.setName(temp);
            
            do {   
                System.out.print("\nEnter your Roll Number: ");
                temp = sc.nextLine();
                if (temp.length() != 4) {
                    System.out.println("Enter correct 4 digit Roll Number");
                    continue;
                }
                cand.setRollNo(temp);
                flag = false;
            } while (flag);
        
            System.out.print("\nEnter your Subject: ");
            temp = sc.nextLine();
            cand.setSubject(temp);
            
            System.out.print("\nEnter your College: ");
            temp = sc.nextLine();
            cand.setCollege(temp);
            
            System.out.print("\nEnter your University: ");
            temp = sc.nextLine();
            cand.setUniversity(temp);
        
        } while(!candidateRegistration(cand));

        System.out.println("Candidate has been registered. Candidate details are:");
        System.out.println(cand);
        System.out.println("Note the Registeration ID for center choice filling in future");
        flag = true;
        do {

            System.out.println("\n\nEnter 1 to go for Center Choice Filling\nEnter 2 to go back to Main Menu\n\nEnter Choice: ");
            temp = sc.nextLine();
            
            switch (temp) {
                case "1":
                    flag = false;
                    chooseCenter(cand.uniqueID, sc);            
                    break;
                case "2":
                    flag = false;
                    System.out.println("Note the Registration ID, so you can fill center choice in future\nPress enter to proceed");
                    sc.nextLine();
                    sc.nextLine();
                    break;
                default:
                    System.out.println("\n\nInvalid Input, enter again\n\n");
                    break;
            }
        } while (flag);
    }

    void chooseCenter(String s_id, Scanner sc) {
        
        Candidate cand = verifyRegistrationID(s_id);

        if (cand != null) {
                String[] centerChoice = new String[3];
                boolean flag = true;
                
            do {
                Func.clearScreen();
                showCenters();
                System.out.println("Enter ID of three centers:");
                for(int i = 0; i < 3; i++) {
                    System.out.print("Center" + (i+1) + ": ");
                    centerChoice[i] = sc.nextLine();
                }

                if (!verifyCenters(centerChoice)) {
                    System.out.println("Given Center ID may not be correct. Re-enter\nPress enter to proceed");
                    sc.nextLine(); sc.nextLine();
                }
                
                if (centerAllotment(cand, centerChoice)) {
                    System.out.println("Center successfully alloted\n----- Candidate Details -----");
                    System.out.println(cand);
                    
                    System.out.println("Note your Unique ID (Registration ID is now not valid)");
                    System.out.println("Press Enter key to proceed");
                    sc.nextLine(); sc.nextLine();
                    flag = false;
                }
            } while (flag);
        }
    }

    void displayCenterSeats(String c_id) {
        boolean flag = false;
        for (Center center : centerList) {
            if (center.centerID.equals(c_id)) {
                System.out.println("Details of Center:");
                System.out.println(center);
                System.out.println();
                flag = true;
                break;
            }
        }
        
        if (flag == false) {
            System.out.println("Center ID is not recognized");
        }
    }

    void displayCandidate(String s_id) {
        for (Candidate candidate : candidateList) {
            if (candidate.uniqueID.equals(s_id)) {
                System.out.println(candidate);
                System.out.println();
                return;
            }
        }

        System.out.println("Given ID is not found");
    }

}

public class CenterAllotmentTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CenterAllotment test = new CenterAllotment();
        int flag = 0;
        boolean loop = true;
        do {
            Func.clearScreen();
            
            System.out.println("-------- ACV Exams --------");
            System.out.print("\n1. Candidate Registration\n2. Choice Filling for Centre\n3. Show Candidate\n4. Show Centre Details\n5. Show All Centres\n0. Exit\n\nEnter corresponding number of any option: ");
            flag = sc.nextInt();

            switch (flag) {
                case 1:
                    test.candidateRegistrationProcess(sc);

                    System.out.println("Press Enter key to contine");
                    sc.nextLine(); sc.nextLine();
                    break;
                
                case 2:
                    System.out.print("\nEnter your Registration ID: ");
                    sc.nextLine();
                    test.chooseCenter(sc.nextLine(), sc);

                    System.out.println("Press Enter key to contine");
                    sc.nextLine(); sc.nextLine();
                    break;
                
                case 3:
                    System.out.print("\nEnter your Unique / Registration ID: ");
                    sc.nextLine();
                    test.displayCandidate(sc.nextLine());
                    
                    System.out.println("Press Enter key to contine");
                    sc.nextLine(); sc.nextLine();
                    break;
                
                case 4:
                    System.out.println("Enter Center ID: ");
                    sc.nextLine();
                    test.displayCenterSeats(sc.nextLine());
                    
                    System.out.println("Press Enter key to contine");
                    sc.nextLine(); sc.nextLine();
                    break;
                
                case 5:
                    test.showCenters();
                    
                    System.out.println("Press Enter key to contine");
                    sc.nextLine(); sc.nextLine();
                    break;
                
                case 0:
                    System.out.println("All Registered Candidates are: ");
                    test.showAllCandidates();
                    loop = false;
                    
                    System.out.println("Press Enter key to contine");
                    sc.nextLine(); sc.nextLine();
                break;
                
                default:
                    System.out.println("Invalid Choice-- Press Enter key to continue --");
                    sc.nextLine(); sc.nextLine();
                break;
            }
        } while (loop);
        sc.close();
    }
}
