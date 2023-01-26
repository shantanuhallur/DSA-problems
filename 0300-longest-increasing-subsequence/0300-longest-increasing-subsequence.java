class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = 0;
        for(int i=0;i<nums.length;i++) {
            int max = 0;
            for(int j=0;j<i;j++) {
                if(nums[i]>nums[j]){
                    if(dp[j]>max) {
                        max = dp[j];
                    }
                }
                dp[i] = max+1;
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}