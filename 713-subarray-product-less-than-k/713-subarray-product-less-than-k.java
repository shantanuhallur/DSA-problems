class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1)return 0;
        int prod =1;
        int left =0;
        int right =0;
        int res = 0;
        
        while(right<nums.length){
            prod *= nums[right];
            
            while(prod>= k){
                prod /= nums[left];
                left++;
            }
            
            res += right - left +1;  //NO OF CONTIGUOUS SUBARRAYS BETWEEN 2 POINTS. 
            right++;
        }
        return res;
    }
}