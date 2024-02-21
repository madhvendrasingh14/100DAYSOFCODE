public class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        
        if (left == 0 || (left & right) == 0) {
            return 0;
        }

        
        int prefix = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            prefix++;
        }

       
       
        return left << prefix;
    }
}
