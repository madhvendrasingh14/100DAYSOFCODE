class Solution {
    public long largestPerimeter(int[] nums) {
        int size = nums.length;
        long maxPeri = 0;
        Arrays.sort(nums);
        long runningSum[] = new long[size];
        for(int indx = 0; indx < size; indx++){
            if(indx == 0)runningSum[indx] = nums[indx];
            else{
                runningSum[indx] = runningSum[indx-1] + nums[indx];
                
                if(indx >= 2 && nums[indx] < runningSum[indx-1]){
                    maxPeri = Math.max(maxPeri, runningSum[indx]);
                }
            }
        }
        return maxPeri == 0 ? -1 : maxPeri;
    }
}
