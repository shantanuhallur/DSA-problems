class Solution {
    public int sumSubseqWidths(int[] nums) {
     Arrays.sort(nums);
        long ans = 0;
        int n = nums.length;
        long mod = 1000000007;
        long p = 1;
        
        int j =n-1;
        for(int i=0;i<nums.length;i++){
            ans = (ans+ p*nums[i] - p*nums[j])%mod;
            
            p = (p*2)%mod;
            j--;
        }
        
        return (int)ans;
    }
}