import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    
    public static boolean isPalindrome(String str) {
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> st = new ArrayList<>();
        
        System.out.println("Enter the number of words:");
        int n = sc.nextInt();
        sc.nextLine(); 
        System.out.println("Enter the words:");
        for (int i = 0; i < n; i++) {
            st.add(sc.nextLine());
        }
        
        String palindrome = firstPalindrome(st.toArray(new String[0]));
        if (!palindrome.isEmpty()) {
            System.out.println("First palindrome word: " + palindrome);
        } else {
            System.out.println("No palindrome found.");
        }
    }
}
