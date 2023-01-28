class Solution {
public:
int solveOptimal(int n,vector<int>& nums) {
    if(n==0) return 0;
    vector<int> ans;
    ans.push_back(nums[0]);
    for(int i=0;i<n;i++) {
        if(nums[i] > ans.back()) {
            ans.push_back(nums[i]);
        }
        else {
            int idx = lower_bound(ans.begin(),ans.end(),nums[i]) - ans.begin();
            ans[idx] = nums[i];
        }
    }
    return ans.size();
}
    int lengthOfLIS(vector<int>& nums) {
        int n =nums.size();
        return solveOptimal(n,nums);
    }
};