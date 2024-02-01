import java.util.Arrays;

class Solution {
    public int[][] divideArray(int[] a, int k) {
        Arrays.sort(a);
        int p = 0;
        int count = 0;
        int u = a.length / 3;
        int arr[][] = new int[u][3];
        
        for (int i = 0; i < a.length; i = i + 3) {
            if (i + 2 < a.length && a[i + 1] - a[i] <= k && a[i + 2] - a[i + 1] <= k && a[i+2]-a[i] <= k) {
                for (int j = 0; j < 3; j++) {
                    arr[count][j] = a[i + j];
                }
                count++;
            }
        }

        if (count == u) {
            return arr;
        } else {
            
            
            return new int[0][0];
        }
    }
}
