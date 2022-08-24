class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i=0;
        int s = 0;
        int max_length=0;
        while(i<nums.length){
            while(nums[i]!=1){
                s++;
                i=s;
                 if(i>=nums.length)break;
            }
            if(i>=nums.length)break;
            while(nums[i]==1){
                i++;
                if(i>=nums.length)break;
            }
            max_length = Math.max(max_length,i-s);
            s=i;
        }
        return max_length;
    }
}