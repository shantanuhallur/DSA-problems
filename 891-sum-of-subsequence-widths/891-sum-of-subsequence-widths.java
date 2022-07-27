class Solution {
    public int sumSubseqWidths(int[] nums) {
     Arrays.sort(nums);
        long ans = 0;
        long mod = 1000000007;
        int n = nums.length;
        long[]pow = new long[n];
        pow[0]=1;
        
        for(int i=1;i<n;i++){
            pow[i]=(pow[i-1]*2)%mod;
        }
        for(int i=0;i<n;i++){
            ans = (ans+nums[i]*(pow[i]-pow[n-1-i]))%mod;
        }
        return (int)ans;
    }
}