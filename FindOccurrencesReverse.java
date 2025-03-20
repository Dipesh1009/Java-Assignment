import java.util.Scanner;

public class FindOccurrencesReverse {
    public static void findOccurrences(String text, String pattern) {
        int textLength = text.length();
        int patternLength = pattern.length();
        int count = 0;
        
        System.out.println("Occurrences of \"" + pattern + "\" in reverse order:");
        
        for (int i = textLength - patternLength; i >= 0; i--) {
            boolean found = true;
            
            for (int j = 0; j < patternLength; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    found = false;
                    break;
                }
            }
            
            if (found) {
                System.out.println("Found at index: " + i);
                count++;
            }
        }
        
        System.out.println("Total occurrences: " + count);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the text: ");
        String text = scanner.nextLine();
        
        System.out.print("Enter the character or string to find: ");
        String pattern = scanner.nextLine();
        
        scanner.close();
        
        findOccurrences(text, pattern);
    }
}
