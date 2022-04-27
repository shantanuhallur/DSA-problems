class Solution {
    
    public int climbtairs (int n ,int[] dp){
        if(n<0){
            return 0;
        }
        if(n==0){
            return dp[0]=1;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        
        
        
        
        return dp[n]=climbtairs (n -1 , dp) + climbtairs (n -2 , dp);
    }
    public int climbStairs(int n) {
            int[] dp = new int[n+1];
           return climbtairs(n,dp);
    }
}