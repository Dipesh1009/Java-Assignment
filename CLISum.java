public class CLISum {
    public static void main(String s[]){
        int sum = 0, avg, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (String i : s) {
            avg = Integer.parseInt(i);
            sum += avg;
            min = (min < avg) ? min : avg;
            max = (max > avg) ? max : avg;
        }
        avg = sum / s.length;
        System.out.println ("Sum :\t\t" + sum );
        System.out.println ("Average :\t" + avg );
        System.out.println ("Minimum :\t" + min );
        System.out.println ("Maximum :\t" + max );
    }
}
