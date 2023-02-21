class Solution {
    public long largestEvenSum(int[] nums, int k) {
        Arrays.sort(nums);
        int minEven = -1, minOdd = -1;
        int maxEven = -1, maxOdd = -1;
        long total = 0 , ans = -1;
        for(int i=nums.length-1;i>=nums.length-k;i--) {
            total += nums[i];    
            if(nums[i]%2==0) {
                minEven = nums[i];
            }
            else {
                minOdd = nums[i];
            }
        }
        if(total%2==0) return total;
        
        for(int i=0;i<nums.length-k;i++) {
            if(nums[i]%2==0) {
                maxEven = nums[i];
            }
            else {
                maxOdd = nums[i];
            }
        }
        
        if(minEven != -1 && maxOdd != -1) ans = Math.max(ans,total-minEven+maxOdd);
        if(minOdd != -1 && maxEven != -1) ans = Math.max(ans,total-minOdd+maxEven);
        return ans;
    }
}



