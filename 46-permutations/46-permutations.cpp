class Solution {
public:
    vector<vector<int>>ans;
    
    void permute1(vector<vector<int>> &ans,int idx , vector<int>& nums){
        if(idx==nums.size()){
            ans.push_back(nums);
        }
        for(int i=idx;i<nums.size();i++){
            swap(nums[i],nums[idx]);
            permute1(ans,idx+1,nums);
            swap(nums[i],nums[idx]);
        }
    }
    vector<vector<int>> permute(vector<int>& nums) {
        permute1(ans,0,nums);
        return ans;
    }
};