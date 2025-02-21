
import java.util.Scanner;

public class ArrayMerge {
    public static int sortAndMerge(int finalArr[], int arr[], int n) {
        int k;
        for (int i = n, j = 0; j < arr.length; i++,j++) {
            k = i;
            while (k > 0) {
                if (arr[j] < finalArr[k-1]) {
                    k--;
                }
                else {
                    break;
                }
            }     
            
            if (k != 0 && finalArr[k-1] == arr[j]){
                i--;
                continue;
            }
            else if (k == 0 && i == 0) {
                finalArr[k] = arr[j];
                n++;
            } 
            else {
                for (int m = n+j-1; m >= k; m--) {
                    finalArr[m+1] = finalArr[m];
                }
                finalArr[k] = arr[j];
                n++;
            }
        }
        return n;
    }
    public static void main (String s[]) {
        Scanner sc = new Scanner (System.in);

        //Taking input for first array

        System.out.print("Enter the no. of elements in first array: ");
        int n = sc.nextInt();
        int array1[] = new int[n];
        System.out.print("Enter elements in first array: ");
        for(int i = 0; i < n; i++) {
            System.out.print("Element " + (i+1));
            array1[i] = sc.nextInt();
        }

        //Taking input for second array

        System.out.print("Enter the no. of elements in second array: ");
        n = sc.nextInt();
        int array2[] = new int[n];
        System.out.print("Enter elements in first array: ");
        for(int i = 0; i < n; i++) {
            System.out.println("Element " + (i+1));
            array2[i] = sc.nextInt();
        }

        //Taking input for Third array

        System.out.print("Enter the no. of elements in third array: ");
        n = sc.nextInt();
        int array3[] = new int[n];
        System.out.print("Enter elements in first array: ");
        for(int i = 0; i < n; i++) {
            System.out.println("Element " + (i+1));
            array3[i] = sc.nextInt();
        }

        //Taking input for Fourth array

        System.out.print("Enter the no. of elements in fourth array: ");
        n = sc.nextInt();
        int array4[] = new int[n];
        System.out.print("Enter elements in first array: ");
        for(int i = 0; i < n; i++) {
            System.out.println("Element " + (i+1));
            array4[i] = sc.nextInt();
        }

        //Creating big array
        int finalArray[] = new int[array1.length + array2.length + array3.length + array4.length];
        n = 0;

        n = sortAndMerge(finalArray, array1, n);
        n = sortAndMerge(finalArray, array2, n);
        n = sortAndMerge(finalArray, array3, n);
        n = sortAndMerge(finalArray, array4, n);

        System.out.println("Final Array: ");
        for (int i : finalArray) {
            System.out.println(i + "\t");
        }
        sc.close();
    }
}
