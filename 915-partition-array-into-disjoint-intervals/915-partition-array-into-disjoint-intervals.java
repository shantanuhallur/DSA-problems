class Solution {
    public int partitionDisjoint(int[] nums) {
        int leftMax = nums[0];
        int dummyLeft = nums[0];
        int ans = 0;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]>leftMax){
                leftMax=nums[i];
            }else if(nums[i]<dummyLeft){
                dummyLeft = leftMax;
                ans = i;
            }
        }
        
        
        return ans+1;
        
    }
}