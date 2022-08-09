class Solution {
    public int searchInsert(int[] nums, int target) {
        int s = 0;
        int e = nums.length-1;
        
        while(s<e){
            int mid = s + (e-s)/2;
            if(target == nums[mid]){
                return mid;
            }
            else if(nums[mid]>target){
                e = mid;
            }
            else{
                s = mid+1;
            }
        }
        return nums[s]<target?s+1:s;
    }
}