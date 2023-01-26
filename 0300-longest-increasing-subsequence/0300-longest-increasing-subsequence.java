class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            dp[i]=100;
        }
        for(int i=0;i<nums.length;i++) {
            int max = 0;
            for(int j =0;j<i;j++) {
                if(nums[j]<nums[i]) {
                    if(dp[j]+1 > max) {
                        max = dp[j];
                    }
                }           
            }
            dp[i] = max+1;
        }
        int max2 = 0;
        for(int i=0;i<nums.length;i++) {
            max2 = Math.max(max2,dp[i]);
        }
        return max2;
    }
}