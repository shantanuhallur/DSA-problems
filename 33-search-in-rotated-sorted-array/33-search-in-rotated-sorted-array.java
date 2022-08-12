class Solution {
    public int search(int[] nums, int target) {
        int lo=0;
        int hi = nums.length -1;
        
        while(lo<hi){
            int mid = (lo+hi)/2;
            
            if(nums[mid]<nums[hi]){
                hi = mid;
            }
            else {
                lo = mid+1; 
            }
        }
        
        int pivot = lo;
        int s1 = BinarySearch(nums,0,pivot-1,target);
        if(s1!=-1){
            return s1;
        }
        else{
            return BinarySearch(nums,pivot,nums.length-1,target);
        }
        
    }
    
    public int BinarySearch(int[] nums,int lo,int hi,int target){
        
        while(lo<=hi){
            int mid = (lo+hi)/2;
            
            if(nums[mid]>target){
                 hi = mid-1;
            }
            else if(nums[mid]<target){
                lo = mid+1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}