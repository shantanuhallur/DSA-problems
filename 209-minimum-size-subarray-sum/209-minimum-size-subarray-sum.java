class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int s = 0;
        int e = 0;
        int length=Integer.MAX_VALUE;
        int sum=nums[s];
        while(e<nums.length){
            while(sum<target){
                e++;
                if(e<nums.length){
                    sum += nums[e];
                }
                
                if(e>=nums.length)break;
            }
             if(e>=nums.length)break;
            length = Math.min(length,e-s +1);
            while(sum>=target){
                 sum -=nums[s];
                s++;
                if(sum>=target)length = Math.min(length,e-s +1);
            }
        }
        return length==Integer.MAX_VALUE?0:length;
    }
}