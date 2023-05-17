class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n];
        tails[0] = nums[0];
        int len =1;
        for(int i=0;i<n;i++) {
            if(nums[i]>tails[len-1]) {
                tails[len] = nums[i];
                len++;
            }
            else {
               int idx = Arrays.binarySearch(tails,0,len-1,nums[i]);
                if(idx<0) {
                    idx = -idx;
                    idx = idx-1;
                }
                tails[idx] = nums[i];
            }
        }
        return len;
    }
}