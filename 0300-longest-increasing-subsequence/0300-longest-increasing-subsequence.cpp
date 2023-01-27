class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp(n,1);
        int maxAns = 0;
        for(int i =0;i<n;i++) {
            int maxLen = 0;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]) {
                    if(dp[j]+1>maxLen) {
                        maxLen = dp[j];
                    }
                }
            }
            dp[i] = maxLen+1;
            maxAns = max(maxAns,dp[i]);
        }
        return maxAns;
    }
};