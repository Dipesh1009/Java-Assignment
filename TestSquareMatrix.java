import java.lang.*;
import java.util.Scanner;

class SquareMatrix {
    int[][] matrix;

    SquareMatrix(int n, Scanner sc) {
        this.matrix = new int[n][n];
        readMatrix(sc);
    }

    private void readMatrix(Scanner sc) {
        System.out.println("Enter values of matrix in row major order");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("Enter Value (" + i + "," + j + "): ");
                matrix[i][j] = sc.nextInt();
            }
        }
        
    }

    boolean isUpperTriangular() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i > j && matrix[i][j] != 0){
                    return false;
                }
            }
        }
        return true;
    }

    boolean isLowerTriangular() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i < j && matrix[i][j] != 0){
                    return false;
                }
            }
        }
        return true;
    }

    boolean isSparse() {
        int n = matrix[0].length;
        int limit = (int)((matrix.length * matrix[0].length) * 0.66);
        for (int rows[] : matrix) {
            for (int i : rows) {
                if (i == 0) {
                    limit--;
                    if (limit <= 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean isIdentityMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if ( i == j && matrix[i][j] != 1) {
                    return false;
                }
                if ( i != j && matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public String toString () {
        String s = "";
        for (int rows[]: matrix) {
            s += "[\t";
            for (int i : rows) {
                s += i + "\t";
            }
            s += "]\n";
        }
        return s;
    }
}

public class TestSquareMatrix {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.print("Enter size of square matrix: ");
        int n = read.nextInt();
        SquareMatrix s = new SquareMatrix(n,read);
        read.close();

        System.out.println("Given Matrix");
        System.out.println(s);
        if (s.isIdentityMatrix()) {
            System.out.println("matrix is Identity");
        } else {
            System.out.println("Matrix is not identity");
        }

        if (s.isLowerTriangular() && s.isUpperTriangular()){
            System.out.println("Matrix is not triangular");
        } else if (s.isLowerTriangular()) {
            System.out.println("Matrix is Lower Triangular");
        } else if (s.isUpperTriangular()) {
            System.out.println("Matrix is Upper Triangular");
        } else {
            System.out.println("Matrix is not triangular");
        }

        if (s.isSparse()) {
            System.out.println("Matrix is sparse");
        } else {
            System.out.println("Matrix is dense");
        }

    }
}