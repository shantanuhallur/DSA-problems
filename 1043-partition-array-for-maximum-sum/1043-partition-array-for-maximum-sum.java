class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        for(int i=1;i<n;i++) {
            int max = 0;
            int max_value = 0;
            for(int j=i;j>=Math.max(0,i-k+1);j--) {
                max_value = Math.max(arr[j],max_value);
                if(j>0) {    
                    max = Math.max(max,max_value*(i-j+1)+dp[j-1]);
                }
                else if(j==0) {
                    max = Math.max(max,max_value*(i-j+1));
                }
            }
            dp[i] = max;
        }
        return dp[n-1];
    }
}