class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int val:nums){
            if(val < min){
                min = val;
            }
            
            if(val>max){
                max = val;
            }
        }
        int ans = (max-k) - (min+k)<0?0:(max-k) - (min+k);
        return ans;
    }
}