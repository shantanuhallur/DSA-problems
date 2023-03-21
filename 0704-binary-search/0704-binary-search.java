class Solution {
    public int search(int[] nums, int target) {
        int res = -1;
        int st = 0;
        int end = nums.length-1;
        
        while(st<=end) {
            int mid = st + (end-st/2);
            
            if(nums[mid] == target) {
                res = mid;
                return res;
            }
            else if(nums[mid]>target) {
                end = mid-1;
            }
            else {
                st = mid+1;
            }
        }
        return res;
    }
}