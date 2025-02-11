import java.lang.*;


public class MinMaxDivergence {
    public static void getDiverged(String array[]) {
        float avg = 0, m;
        for (String n : array) {
            avg += Integer.parseInt(n);
        }
        avg /= array.length;
        Float minDiff = Float.MAX_VALUE, maxDiff = Float.MIN_VALUE, min = Float.NaN, max = Float.NaN ;
        System.out.println(avg);
        
        for (String n : array) {
            m = Float.parseFloat(n);
            if (maxDiff < Math.abs(avg - m)) {
                maxDiff = Math.abs(avg - m);
                max = m;
            }
            if (minDiff > Math.abs(avg - m)) {
                minDiff = Math.abs(avg - m);
                min = m;
            }
        }

        System.out.println("Maximum divergence is " + max);
        System.out.println("Minimum divergence is " + min);
    }
    public static void main(String[] args) {
        getDiverged(args);
    }
}