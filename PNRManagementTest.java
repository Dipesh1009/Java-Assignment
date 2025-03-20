

class Seat {
    static int seatsInBogie;
    String seq_no;
    String nameOfPassenger;
    String genderOfPassenger;
    String ageOfPassenger;
    char typeOfSeat;
    boolean state;

    Seat() {}

    void setSeatLayout(String seq_no) {
        this.seq_no = seq_no;
        typeOfSeat = getLayout(seq_no);
        state = false;
    }

    char getLayout(String seq_no) {
        int seq = Integer.parseInt(seq_no); 
        if (seq % 8 == 0) {
            seq /= 8;
        }
        if (seq <= 8) {
            switch (seq) {
                case 1:
                case 4:
                    return 'L';
                case 2:
                case 5:
                    return 'M';
                case 3:
                case 6:
                    return 'U';
                case 7:
                    return 'X';
                case 8:
                    return 'Y';
                default:
                    return 'N';
            }
        }
        else {
            switch(seq % 8) {
                case 1:
                case 4:
                    return 'L';
                case 2:
                case 5:
                    return 'M';
                case 3:
                case 6:
                    return 'U';
                case 7:
                    return 'X';
                case 0:
                    return 'Y';
                default:
                    return 'N';
            }
        }
    }

    void setName (String nameOfPassenger) {
        this.nameOfPassenger = nameOfPassenger;
    }
    void setGender (String genderOfPassenger) {
        this.genderOfPassenger = genderOfPassenger;
    }
    void setAge (String ageOfPassenger) {
        this.ageOfPassenger = ageOfPassenger;
    }
    void setState() {
        this.state = !this.state;
    }

    void setDetails(String nameOfPassenger, String genderOfPassenger, String ageOfPassenger) {
        setName(nameOfPassenger);
        setAge(ageOfPassenger);
        setGender(genderOfPassenger);
        setState();
    }

    String getName() {
        return nameOfPassenger; 
    }

    String getGender() {
        return genderOfPassenger;
    }

    String getAge() {
        return ageOfPassenger;
    }

    boolean getState() {
        return state;
    }
}

class Bogie {
    int capacity;
    String trainNo;
    String bogieID;
    String sequenceNo;
    Seat[] noOfSeats;
    char type;


    Bogie() {
        bogieID = "G1";
        capacity=8;
        noOfSeats = new Seat[capacity];
        this.trainNo = "1111";
        this.type = 'G';
        this.sequenceNo = null;
    }

    Bogie(int capacity, String trainNo, char type, String sequenceNo, String bogieID) {
        this.bogieID = bogieID;
        this.capacity = capacity;
        this.trainNo = trainNo;
        noOfSeats = new Seat[capacity];
        this.type = type;
        this.sequenceNo = sequenceNo;
    }
    
    void setUpSeats() {
        for (int i=0; i<capacity; i++) {
                noOfSeats[i].setSeatLayout(String.valueOf(i+1));
        }
    }

}

class Station {
    String name;
    String stationID;

    Station() {

    }

    Station(String name, String stationID) {
        this.name = name;
        this.stationID = stationID;
    }
}

class StationArray {
    Station[] stations = {
        new Station("Indore", "00"),
        new Station("Bhopal", "01"),
        new Station("Gwalior", "02"),
        new Station("Jhansi", "03"),
        new Station("Agra", "04"),
        new Station("Noida", "05"),
        new Station("Delhi", "06"),
        new Station("Ahmedabad", "07"),
        new Station("Surat", "08"),
        new Station("Sagar", "09"),
        new Station("Raipur", "10"),
        new Station("Bangalore", "11"),
        new Station("Hyderabad", "12"),
        new Station("Kolkata", "13"),
        new Station("Ranchi", "14"),
        new Station("Pune", "15"),
        new Station("Jaipur", "16"),
        new Station("Panipat", "17"),
        new Station("Udaipur", "18"),
        new Station("Gurgaon", "19"),
        new Station("Ujjain", "20"),
        new Station("Kanpur", "21"),
        new Station("Ajmer", "22"),
        new Station("Jabalpur", "23"),
        new Station("Nashik", "24"),
        new Station("Shivpuri", "25"),
    };
}

class Routes {
    Station [] r1 = {
        
    };
}

class Railways {
    
}

class Train {
    Bogie[] train;
    String trainID;
    String trainName;
    String startStation;
    String finalStation;
    String startTiming;
    String finalTiming;

    Train() {

    }

    Train(String trainID, String trainName, String startStation, String finalStation, String startTiming) {
        this.trainID = trainID;
        this.trainName = trainName;
        this.startStation = startStation;
        this.finalStation = finalStation;
        this.startTiming = startTiming;
    }

    void calculateTiming(String startTiming){

    }

}


class TrainManager {

}

class PNRManager {

}

class PNRManagementTest {
    
}
