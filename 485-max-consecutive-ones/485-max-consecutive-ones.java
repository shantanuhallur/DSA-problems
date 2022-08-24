class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int current_ones=0;
        int max_length=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                current_ones +=1;
                max_length = Math.max(max_length,current_ones);
            }
            else{
                current_ones=0;
            }
        }
        return max_length;
    }
}