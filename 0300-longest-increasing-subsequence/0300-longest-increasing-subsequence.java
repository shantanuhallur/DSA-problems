class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int n = nums.length;
        int maxAns=0;
        for(int i=0;i<n;i++) {
            int maxLen =0;
            for(int j=0;j<i;j++) {
                if(nums[i]>nums[j]) {
                    if(dp[j]+1>maxLen) {
                        maxLen = dp[j];
                    }
                }
            }
            dp[i] = maxLen+1;
            maxAns = Math.max(maxAns, dp[i]);
        }
        return maxAns;
    }
}