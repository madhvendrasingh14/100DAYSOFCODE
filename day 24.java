class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int count;
        for(int i=0;i<=n;i++)
        {
            count=0;
            for(int j=0;j<n;j++){
                if(i==nums[j])
                {
                    count++;
                    break;
                }

            }
            if(count==0)
            {
                return i;
                
            }

            
        }
        return -1;
        
    }
}
