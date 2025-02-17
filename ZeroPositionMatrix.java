import java.lang.*;

public class ZeroPositionMatrix {
    void displayZeroPosition(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++){
                if (arr[i][j] == 0) {
                    System.out.println("Index of Zero: " + "(" + i + "," + j + ")");
                }
            }
        }     
    }
    public static void main(String[] args) {
        int[][] arr = {{1,2,0},
                       {0,2,0},
                       {3,1,0}}; 
        ZeroPositionMatrix p = new ZeroPositionMatrix();
        p.displayZeroPosition(arr);
    }
}
