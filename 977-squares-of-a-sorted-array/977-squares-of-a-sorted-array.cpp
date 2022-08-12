class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        list<int>ans;
        int start =0;
        int end = nums.size()-1;
        
        while(start<=end){
            int val1 = nums[start]*nums[start];
            int val2 = nums[end]*nums[end];
            
            if(val1>val2){
                ans.push_front(val1);
                start++;
            }
            else{
                ans.push_front(val2);
                end--;
            }
        }
         vector<int>realAns;
        for(int val:ans){
            realAns.push_back(val);
        }
       
        return realAns;
    }
};