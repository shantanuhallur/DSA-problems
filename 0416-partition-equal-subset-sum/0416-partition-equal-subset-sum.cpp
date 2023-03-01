class Solution {
public:
    bool canPartition(vector<int>& nums) {
        int numSum =0;
        for(int i=0;i<nums.size();i++) {
            numSum += nums[i];
        }
        if(numSum%2!=0) return false;
        int sum = numSum/2;
        int n = nums.size();
        vector<vector<bool>>dp(n+1,vector<bool>(sum+1,false));
        
        int col =0;
        for(int row = 0 ; row<dp.size();row++) {
            dp[row][col] = true;
        }
        
        for(int i=1;i<n+1;i++) {
            for(int j=1;j<sum+1;j++) {
                if(nums[i-1]<=j) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
};