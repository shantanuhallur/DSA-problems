class Solution {
    public long countSubarrays(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i=1;i<nums.length;i++) {
            if(nums[i-1]<nums[i]) {
                dp[i] = 1+dp[i-1];
            }
            else {
                dp[i] = 1;
            }
        }
        long ans= 0;
        for(int i=0;i<dp.length;i++) {
            ans += dp[i];
        }
        return ans;
    }
}