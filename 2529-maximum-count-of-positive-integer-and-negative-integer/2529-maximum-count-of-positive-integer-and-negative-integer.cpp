class Solution {
public:
    int getPos(vector<int>& nums) {
        int s =0;
        int e = nums.size()-1;
        int res = -1;
        while(s<=e) {
            int mid = s + (e-s/2);
            if(nums[mid]>0) {
                res = mid;
                e = mid-1;
            }
            else if(nums[mid]<=0) {
                s = mid+1;
            }
        }
        return res != -1? nums.size()-res : res;
    }
    
    int getNeg(vector<int>& nums) {
        int s =0;
        int e = nums.size()-1;
        int res = -1;
        while(s<=e) {
            int mid = s + (e-s/2);
            if(nums[mid]>=0) {
                e = mid-1;
            }
            else if(nums[mid]<0) {
                res = mid;
                s = mid+1;
            }
        }
        return res != -1? res+1 : res;
    }
    int maximumCount(vector<int>& nums) {
        int num1 = getPos(nums);
        int num2 = getNeg(nums);
        cout<< num1 << " " << num2;
        if(num1 == -1 && num2 == -1) return 0;
        return max(num1,num2);
    }
};