import java.util.*;

public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> charFreq = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> charFreq.get(b) - charFreq.get(a));
        pq.addAll(charFreq.keySet());
        
        StringBuilder sortedString = new StringBuilder();
        while (!pq.isEmpty()) {
            char c = pq.poll();
            int freq = charFreq.get(c);
            for (int i = 0; i < freq; i++) {
                sortedString.append(c);
            }
        }
        
        return sortedString.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String input = scanner.nextLine();
        scanner.close();
        
        Solution solution = new Solution();
        System.out.println("Sorted string: " + solution.frequencySort(input));
    }
}
