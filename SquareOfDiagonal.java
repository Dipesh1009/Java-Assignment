import java.util.Scanner;

class DiagonalSquare {
    int [][] m;

    DiagonalSquare() {}

    DiagonalSquare(int n, Scanner sc) {
        m = new int [n][n];
        readMatrix(sc);
    }
    
    DiagonalSquare(int[][] m) {
        this.m = m;
    }

    private void readMatrix(Scanner sc) {
        System.out.println("Enter values of matrix in row major order");
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print("Enter Value (" + i + "," + j + "): ");
                m[i][j] = sc.nextInt();
            }
        }
        
    }
    

    void squareOfDiagonal() {
        int s1 = 0, s2 = 0;
        for (int i = 0; i < m.length ; i++ ) {
            for (int j = 0; j < m[0].length; j++) {
                if (i == j) {
                    s1 += m[i][j] * m[i][j];
                }
                if (j == m[0].length - i){
                    s2 += m[i][j] * m[i][j];
                }
            }
        }

        System.out.println("Sum of Diagonal 1: " + s1);
        System.out.println("Sum of Diagonal 2: " + s2);
    }
}

class SquareOfDiagonal {
    public static void main(String[] args) {
        int[][] m = {{1,2,1},
                     {2,1,3},
                     {1,2,1}};
        DiagonalSquare matrix = new DiagonalSquare(m);
        matrix.squareOfDiagonal();
    }
}

