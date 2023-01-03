class Solution {
    public int numberOfNodes(int n, int[] queries) {
        int[] dp = new int[n+1];
        int on = 0;
        for(int query : queries) {
            dp[query]++;
        }
        
        for(int i=1;i<n+1;i++) {
            if(i!=1) {
                dp[i] += dp[i/2];
                
            }
                if(dp[i]%2==1) on++;
        }
        return on;
    }
}