class Solution {
    public int numberOfNodes(int n, int[] queries) {
        int[] dp = new int[n+1];
        
        for(int query : queries) dp[query] ^=1;
        
        int result = dp[1];

        for (int i = 2; i <= n; i++) {
            dp[i] ^= dp[i / 2];
            result += dp[i]; // XOR USED TO TOGGLE 0 to 1 and 1 to 0;
        }

        return result;
    }
}