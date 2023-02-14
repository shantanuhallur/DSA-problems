class Solution {
public:
    int minimumSplits(vector<int>& nums) {
        int currgcd = nums[0];
        int split = 1;
        for(int i=0;i<nums.size();i++) {
            if(gcd(currgcd,nums[i])==1) {
                split++;
                currgcd = nums[i];
            }
            else {
                currgcd = gcd(currgcd,nums[i]);
            }
        }
        return split;   
    }
};