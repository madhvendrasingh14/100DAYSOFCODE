import java.util.*;

public class Solution {
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(freqMap::get));
        pq.addAll(freqMap.keySet());

        while (k > 0) {
            int num = pq.poll();
            int freq = freqMap.get(num);
            if (freq <= k) {
                k -= freq;
                freqMap.remove(num);
            } else {
                freqMap.put(num, freq - k);
                k = 0;
            }
        }

        return freqMap.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        int result = findLeastNumOfUniqueInts(arr, k);
        System.out.println("Least number of unique integers after removing " + k + " elements: " + result);
    }
}
