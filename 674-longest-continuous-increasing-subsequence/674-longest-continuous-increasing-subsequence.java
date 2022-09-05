class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int i=0;
        int j=1;
        int len=1;
        while(j<nums.length){
                while(nums[j]>nums[j-1]){
                    j++;
                    if(j-i+1>len){
                        len = j-i;
                    }
                    if(j>=nums.length)break;
                }
            i=j;
            j++;
        }
        return len;
    }
}