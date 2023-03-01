class Solution {
public:
    bool canPartition(vector<int>& nums) {
        int numSum =0;
        for(int i=0;i<nums.size();i++) {
            numSum += nums[i];
        }
        if(numSum%2!=0) return false;
        vector<vector<bool>>dp(nums.size()+1,vector<bool>((numSum/2)+1,false));
        
        int col =0;
        for(int row = 0 ; row<dp.size();row++) {
            dp[row][col] = true;
        }
        
        for(int i=1;i<dp.size();i++) {
            for(int j=1;j<dp[0].size();j++) {
                if(nums[i-1]<=j) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.size()][numSum/2];
    }
};