class Solution {
public:
    vector<int> largestDivisibleSubset(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int n = nums.size();
        vector<int> dp(n,1);
        vector<int> prev_idx(n,-1);
        
        for(int i=0;i<n;i++) {
            for(int j=i-1;j>=0;j--) {
                if(dp[j]+1>dp[i] && nums[i]%nums[j]==0) {
                    dp[i] = dp[j]+1;
                    prev_idx[i] = j;
                }
            }
        }
        
        int maxLen =0; int idx = 0;
        for(int i=0;i<n;i++) {
            if(maxLen<dp[i]) {
                maxLen = dp[i];
                idx = i;
            }
        }
        vector<int> ans;
        while(idx!=-1) {
            ans.push_back(nums[idx]);
            idx = prev_idx[idx];
        }
        return ans;
    }
};