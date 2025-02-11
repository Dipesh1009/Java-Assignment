public class CLIChoice {
    static long findFactorial(int n) {
        long fact = 1;
        if(n == 0) {
            return fact;
        }
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
    public static void main(String args[]){
        int v;
        try {
            v = Integer.parseInt(args[1]);
            switch(args[0]) {
                case "fact":
                case "FACT":
                case "Fact":
                    System.out.println("Factorial of " + args[1] + ": " + findFactorial(v));
                    break;
                case "SQUARE":
                case "square":
                case "Square":
                    System.out.println("Square of " + args[1] + ": " + v*v);
                    break;
                case "CUBE":
                case "cube":
                case "Cube":
                    System.out.println("Cube of " + args[1] + ": " + v*v*v);
                    break;
                default:
                    System.out.println("Invalid Option!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
