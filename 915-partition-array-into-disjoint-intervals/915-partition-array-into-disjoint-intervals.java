class Solution {
    public int partitionDisjoint(int[] nums) {
        int leftMax = nums[0];
        int maxElementInRightArray = nums[0];
        int ans = 0;
//Our max value in scanner right array can potentially be the left max for our left array iff we find an element which is smaller than our current leftMax in the RIGHT ARRAY.         
        for(int i=0;i<nums.length;i++){
            if(nums[i]>maxElementInRightArray){
                maxElementInRightArray = nums[i];
            }else if(nums[i]<leftMax){
                leftMax = maxElementInRightArray;
                ans = i;
            }
        }
        
        
        return ans+1;
        
    }
}