import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 1; i <= 9; i++) {
            int num = i;
            int nextDigit = i;

            while (num <= high && nextDigit < 10) {
                if (num >= low) {
                    result.add(num);
                }
                nextDigit++;
                num = num * 10 + nextDigit;
            }
        }

        Collections.sort(result);
        return result;
    }
}
