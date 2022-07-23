class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
      int e = -1;
        int s = -1;
        int res = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>= left && nums[i]<= right){
                e=i;
            }
            else if(nums[i]>=right){
                e=s=i;
            }
            else if(nums[i]<right){
                
            }
            res += (e-s);
        }
       
        return res;
    }
}