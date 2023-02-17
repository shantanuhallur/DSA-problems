class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.size() ==1)return nums[0];
        if(nums.size()==2)return max(nums[0],nums[1]);

        vector<int> dp(nums.size()+1);
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i=1 ;i<nums.size();i++){    
                dp[i+1] = max(dp[i-1]+nums[i] , dp[i]);
        
        }
        
        return dp[nums.size()];
    }
};