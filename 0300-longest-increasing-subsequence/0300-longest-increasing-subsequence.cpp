class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        vector<int>lis(nums.size(),1);
        int n = nums.size();
        int omax = 0;
            for(int i=0;i<n;i++) {
                int max = 0;
                for(int j=0;j<i;j++) {
                    if(nums[i]>nums[j]) {
                        if(max<lis[j]+1) {
                            max = lis[j];
                        }
                    }
                }
                lis[i] = max+1;
                if(omax<lis[i]) omax = lis[i];
            }
        return omax;
    }
};