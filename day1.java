

import java.util.HashMap;
import java.util.Scanner;

public class SubmatrixSumToTarget {
    public static int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int count = 0;

        // Iterate through all possible starting rows
        for (int top = 0; top < m; top++) {
            int[] rowSum = new int[n]; // Store prefix sums for each row

            // Calculate prefix sums for each row from top to bottom
            for (int bottom = top; bottom < m; bottom++) {
                for (int col = 0; col < n; col++) {
                    rowSum[col] += matrix[bottom][col];
                }

                // Use a hashmap to efficiently count submatrices with target sum
                count += countSubmatricesWithTargetSum(rowSum, target);
            }
        }

        return count;
    }

    // Count submatrices with target sum in a 1D array of prefix sums
    private static int countSubmatricesWithTargetSum(int[] rowSum, int target) {
        int count = 0;
        int currentSum = 0;
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // Initial count for sum 0

        for (int sum : rowSum) {
            currentSum += sum;
            count += prefixSumCount.getOrDefault(currentSum - target, 0);
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the matrix (each row separated by spaces): ");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        System.out.print("Enter the target value: ");
        int target = scanner.nextInt();

        int count = numSubmatrixSumTarget(matrix, target);
        System.out.println("Number of submatrices with target sum: " + count);

        scanner.close();
    }
}
