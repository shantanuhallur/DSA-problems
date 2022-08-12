class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
       
        int start =0;
        int end = nums.size()-1;
        vector<int>ans;
     
        while(start<=end){
            int val1 = nums[start]*nums[start];
            int val2 = nums[end]*nums[end];
            
            if(val1>val2){
                 ans.push_back(val1);
                start++;
            }
            else{
               ans.push_back(val2);
                end--;
            }
        }
       reverse(ans.begin(),ans.end());
       
        return ans;
    }
};