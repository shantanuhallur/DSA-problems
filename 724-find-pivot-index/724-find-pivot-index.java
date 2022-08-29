class Solution {
    public int pivotIndex(int[] nums) {
        int total_sum=0;
        int left_sum =0;
        for(int val:nums){
            total_sum += val;
        }
        
        for(int i=0;i<nums.length;i++){
           
            if(total_sum - left_sum - nums[i] == left_sum){
                return i;
            }
             left_sum += nums[i];
        }
        return -1;
    }
}