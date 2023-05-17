class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int ans =  -1e9;
        int cprod=1;
        //subarray including elements from start
        for(int i=0;i<nums.size();i++){
            cprod*= nums[i];
            ans = max(ans,cprod);
            
            if(cprod==0){
                cprod = 1;
            }
        }
        
        //subarray including elements from end
        cprod = 1;
        for(int i=nums.size()-1;i>=0;i--){
            cprod*= nums[i];
            ans = max(ans,cprod);
            
            if(cprod==0){
                cprod = 1;
            }
        }
        //subarray from start and subarray from end are not equal as either arrays can skip the element from start or end for example :- [2,3,-2,4] start can skip 4 and end can skip anu 3 or 2 for its subarray.
        return ans;
    }
};