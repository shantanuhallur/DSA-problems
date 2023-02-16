class Solution {
public:
    long long countSubarrays(vector<int>& nums) {
       vector<int> dp(nums.size());
        dp[0] = 1;
        for(int i=1;i<nums.size();i++) {
            if(nums[i-1]<nums[i]) {
                dp[i] = 1+dp[i-1];
            }
            else {
                dp[i] = 1;
            }
        }
        long ans= 0;
        for(int i=0;i<dp.size();i++) {
            ans += dp[i];
        }
        return ans; 
    }
};