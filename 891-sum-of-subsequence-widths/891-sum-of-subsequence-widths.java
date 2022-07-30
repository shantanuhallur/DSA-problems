class Solution {
    public int sumSubseqWidths(int[] nums) {
     Arrays.sort(nums);
        long ans = 0;
        int n = nums.length;
        long mod = 1000000007;
        long p = 1;
        
        for(int i=0;i<nums.length;i++){
            ans = (ans+ p*nums[i] - p*nums[n-1-i])%mod;
            
            p = (p*2)%mod;
        }
        
        return (int)ans;
    }
}