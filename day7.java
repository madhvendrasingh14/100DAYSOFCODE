import java.util.Scanner;

public class Solution {
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int currentMax = 0;
            for (int j = 1; j <= Math.min(k, i); j++) {
                currentMax = Math.max(currentMax, arr[i - j]);
                dp[i] = Math.max(dp[i], dp[i - j] + currentMax * j);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the length of the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();
        System.out.println(maxSumAfterPartitioning(arr, k));
    }
}
