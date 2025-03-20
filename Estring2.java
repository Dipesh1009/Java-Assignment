import java.util.Scanner;

class Estring2 {
    public static String convertCase(String input) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (i % 2 == 0) {
                // Convert to lowercase manually
                if (ch >= 'A' && ch <= 'Z') {
                    ch = (char) (ch + ('a' - 'A'));
                }
            } else {
                // Convert to uppercase manually
                if (ch >= 'a' && ch <= 'z') {
                    ch = (char) (ch - ('a' - 'A'));
                }
            }
            result.append(ch);
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();
        
        String convertedString = convertCase(input);
        System.out.println("Converted string: " + convertedString);
    }
}
