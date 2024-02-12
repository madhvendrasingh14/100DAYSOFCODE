import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        
        for (int num : nums) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }
        
        int majorityCount = nums.length / 2;
        for (int key : countMap.keySet()) {
            if (countMap.get(key) > majorityCount) {
                return key;
            }
        }
        
        return -1; // Majority element always exists, so this should never be reached.
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        
        int[] nums = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        
        Solution solution = new Solution();
        System.out.println("The majority element is: " + solution.majorityElement(nums));
        
        scanner.close();
    }
}
