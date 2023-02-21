class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        for(int i=1;i<n;i++) {
            int maxArrNo=0;
            int maxOfAll=0;
            for(int j=i;j>=Math.max(0,i-k+1);j--) {
                maxArrNo = Math.max(maxArrNo,arr[j]);
                if(j>0) {
                    maxOfAll = Math.max(maxOfAll,(i-j+1)*maxArrNo+dp[j-1]);
                }
                else {
                    maxOfAll = Math.max(maxOfAll,(i-j+1)*maxArrNo);
                }
            }
            dp[i] = maxOfAll;
        }
        return dp[n-1];
    }
}