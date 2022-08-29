class Solution {
    public int findMiddleIndex(int[] nums) {
        int total_sum=0;
        int left_sum =0;
        for(int val:nums){
            total_sum += val;
        }
        
        for(int i=0;i<nums.length;i++){
           int right_sum = total_sum - left_sum - nums[i];
            if( right_sum == left_sum){
                return i;
            }
             left_sum += nums[i];
        }
        return -1;
    }
}