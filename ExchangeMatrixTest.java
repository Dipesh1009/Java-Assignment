
class ExchangeMatrix {
    Matrix arr;
    
    ExchangeMatrix() {}
    ExchangeMatrix(int[][] array) {
        this.arr = new Matrix(array);
    }

    Matrix exchangeRowMajor() {
        Matrix mat = new Matrix(arr.rows, arr.cols);
        int avg, i = 0, j = 0, k = arr.rows - 1, l = arr.cols - 1;
        LOOP:
        while (i >= 0) {
            j = 0;
            l = arr.cols - 1;
            while (j >= 0) {
                if (j > arr.cols -1) {
                    break;
                }
                avg = (arr.m[i][j] + arr.m[k][l]) / 2;
                mat.m[i][j] = arr.m[i][j] - avg;
                mat.m[k][l] = arr.m[k][l] - avg;
                if ( i * arr.cols + j > k * arr.cols + l) {
                    break LOOP;
                }
                j++; l--;
            }
            i++; k--;
        }
        return mat;
    }

    Matrix exchangeColumnMajor() {
        Matrix mat = new Matrix(arr.rows, arr.cols);
        int avg, i = 0, j = 0, k = arr.rows - 1, l = arr.cols - 1;
        LOOP:
        while (j >= 0) {
            i = 0;
            k = arr.rows - 1;
            while (i >= 0) {
                if (i > arr.rows -1) {
                    break;
                }
                avg = (arr.m[i][j] + arr.m[k][l]) / 2;
                mat.m[i][j] = arr.m[i][j] - avg;
                mat.m[k][l] = arr.m[k][l] - avg;
                if ( i * arr.rows + j > k * arr.rows + l) {
                    break LOOP;
                }
                i++; k--;
            }
            j++; l--;
        }
        return mat;
    }

}

public class ExchangeMatrixTest {
    public static void main(String[] args) {
        int[][] array = {
            {3,4,8},
            {6,7,9}
        };

        ExchangeMatrix e1 = new ExchangeMatrix(array);
        System.out.println("Given Array:\n" + e1.arr);
        System.out.println("Exchanged Row Major Array:\n" + e1.exchangeRowMajor());
        System.out.println("Exchanged Column Major Array:\n" + e1.exchangeColumnMajor());

    }
}
