class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int cz = 0;
        int ans = 0;
        while(i<nums.length){
            if(nums[i]==0){
                cz++;
            }
            
            while(cz>k){
                if(nums[j]==0){
                    cz--;
                }
                j++;
            }
            
            ans = Math.max(i-j+1,ans);
            i++;
        }
        return ans;
    }
}