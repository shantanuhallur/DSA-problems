class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = binarySearchLeft(0,nums.length-1,nums,target);
        ans[1] = binarySearchRight(0,nums.length-1,nums,target);
        return ans;
    }
    
    public int binarySearchLeft(int s,int e,int[] nums,int target){
        int idx = -1;
        while(s<=e){
            int mid = s +(e-s)/2;
            if(nums[mid]==target){
                idx = mid;
                e = mid-1;
            }
            else if(nums[mid]<target){
                s=mid+1;
            }
            else{
                e= mid-1;
            }
        }
        return idx;
    }
    
    public int binarySearchRight(int s,int e,int[] nums,int target){
        int idx = -1;
        while(s<=e){
            int mid = s +(e-s)/2;
            if(nums[mid]==target){
                idx = mid;
                s = mid+1;
            }
            else if(nums[mid]<target){
                s=mid+1;
            }
            else{
                e= mid-1;
            }
        }
        return idx;
    }
}