class Solution {
public:
    int solveMemo(int n,vector<int>& nums,int curr,int prev,vector<vector<int>>& dp) {
        if(curr==n) return 0; 
        if(dp[curr][prev+1] != -1) return dp[curr][prev+1];
        //Include
        int take = 0;
        if(prev == -1 || nums[curr]>nums[prev])
        take = 1+ solveMemo(n,nums,curr+1,curr,dp);
        
        //exclude
        int notTake = 0 + solveMemo(n,nums,curr+1,prev,dp);
        
        return dp[curr][prev+1] = max(take,notTake);
    }
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
        vector<vector<int>> dp(n,vector<int>(n+1,-1));
        return solveMemo(n,nums,0,-1,dp);
    }
};