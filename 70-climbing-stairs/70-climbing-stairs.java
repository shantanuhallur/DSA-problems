    
class Solution {

    private int climbstairs (int n ,int[] dp){
       if(n<=2) return dp[n]=n==1?1:2;
        
        if(dp[n] != 0) return dp[n];
        
        return dp[n] = climbstairs(n-1,dp)+climbstairs(n-2,dp);
    }
        
     private int climbstairs_tab(int N,int[] dp){
        for(int n=0;n<=N;n++){
            if(n<=2) {
                dp[n]=n==2?2:1;
                continue;
            }
            
         dp[n] = dp[n-1]+dp[n-2];
        }
        return dp[N];
    }
    public int climbStairs(int n) {
            int[] dp = new int[n+1];
           return climbstairs_tab(n,dp);
    }
}