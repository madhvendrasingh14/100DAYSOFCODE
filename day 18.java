import java.util.ArrayList;

class Solution {
    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> t = new ArrayList<>();
        ArrayList<Integer> q = new ArrayList<>();
        int length = nums.length;
        
        // Separate positive and negative numbers
        for (int num : nums) {
            if (num >= 0) {
                t.add(num);
            } else {
                q.add(num);
            }
        }
        
        int[] arr = new int[length];
        int j = 0;
        
        // Interleave positive and negative numbers
        for (int i = 0; i < Math.max(t.size(), q.size()); i++) {
            if (i < t.size()) {
                arr[j++] = t.get(i);
            }
            if (i < q.size()) {
                arr[j++] = q.get(i);
            }
        }

        return arr;
    }
}
