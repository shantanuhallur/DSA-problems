    
class Solution {

    public int climbstairs (int n ,int[] dp){
       if(n<=2) return dp[n]=n==1?1:2;
        
        if(dp[n] != 0) return dp[n];
        
        return dp[n] = climbstairs(n-1,dp)+climbstairs(n-2,dp);
    }
        
    
    public int climbStairs(int n) {
            int[] dp = new int[n+1];
           return climbstairs(n,dp);
    }
}