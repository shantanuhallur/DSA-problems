class Solution {
public:
    vector<vector<int>>ans;
    
    void permute1(vector<vector<int>> &ans,int idx , vector<int>& nums){
        if(idx==nums.size()){
            ans.push_back(nums);
        }
        unordered_set<int> m;
        for(int i=idx;i<nums.size();i++){
            if(m.find(nums[i])==m.end()){
                m.insert(nums[i]);
                swap(nums[i],nums[idx]);
                permute1(ans,idx+1,nums);
                swap(nums[i],nums[idx]);
            }
        }
    }
    
    vector<vector<int>> permuteUnique(vector<int>& nums) {
         permute1(ans,0,nums);
        return ans;
    }
};