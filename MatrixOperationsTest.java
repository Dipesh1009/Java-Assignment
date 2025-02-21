
import java.util.Scanner;

class Matrix {
    int m[][], rows, cols;

    Matrix() {}

    Matrix(int r, int c) {
        m = new int[r][c];
        rows = r; cols = c;
    }

    Matrix(int r, int c, Scanner sc) {
        m = new int[r][c];
        rows = r; cols = c;
        readMatrix(sc);
    }

    Matrix (int n) {
        m = new int[n][n];
        rows = cols = n;
    }

    Matrix(int n, Scanner sc) {
        m = new int [n][n];
        rows = cols = n;
        readMatrix(sc);
    }

    Matrix (int [][] m) {
        this.m = m;
        rows = m.length;
        cols = m[0].length;
    }

    Matrix(Matrix arr) {
        this.m = arr.m;
        this.rows = arr.rows;
        this.cols = arr.cols;
    }

    private void readMatrix(Scanner sc) {
        System.out.println("Enter values of matrix in row major order");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter Value (" + i + "," + j + "): ");
                m[i][j] = sc.nextInt();
            }
        }
        
    }

    public String toString() {
        String s = "";
        for (int row[]: m) {
            s += "[\t";
            for (int i : row) {
                s += i + "\t";
            }
            s += "]\n";
        }
        return s;
    }
}

class MatrixOperations {
    static Matrix addMatrix(Matrix m1, Matrix m2) {
        Matrix sum = new Matrix(m1.rows);
        for(int i = 0; i < m1.rows; i++){
            for (int j = 0; j < m1.cols; j++) {
                sum.m[i][j] = m1.m[i][j] + m2.m[i][j];
            }
        }
        return sum;
    }   
    static Matrix substractMatrix(Matrix m1, Matrix m2) {
        Matrix sub = new Matrix(m1.rows);
        for(int i = 0; i < m1.rows; i++){
            for (int j = 0; j < m1.cols; j++) {
                sub.m[i][j] = m1.m[i][j] - m2.m[i][j];
            }
        }
        return sub;
    }   
    static Matrix multiplyMatrix(Matrix m1, Matrix m2) {
        Matrix mul = new Matrix(m1.rows);
        for(int i = 0; i < m1.rows; i++){
            for (int j = 0; j < m1.cols; j++) {
                mul.m[i][j] = 0;
                for (int k = 0; k < m1.cols; k++) {
                    mul.m[i][j] += m1.m[i][k] * m2.m[k][j];
                }
            }
        }
        return mul;
    }   
}

class MatrixOperationsTest {
    public static void main(String[] args) {
        int[][] m1 = {{1,1,1},
                      {1,1,1},
                      {1,1,1}};

        int[][] m2 = {{2,1,3},
                      {3,1,1},
                      {1,1,1}};

        Matrix mat1 = new Matrix(m1);
        Matrix mat2 = new Matrix(m2);
        System.out.println("Matrix 1:\n" + mat1);
        System.out.println("Matrix 2:\n" + mat2);

        Matrix mat3 = MatrixOperations.addMatrix(mat1, mat2);
        System.out.println("Addition:\n" + mat3);
        
        mat3 = MatrixOperations.substractMatrix(mat1, mat2);
        System.out.println("Substraction:\n" + mat3);

        mat3 = MatrixOperations.multiplyMatrix(mat1, mat2);
        System.out.println("Multiplication:\n" + mat3);
    }
}