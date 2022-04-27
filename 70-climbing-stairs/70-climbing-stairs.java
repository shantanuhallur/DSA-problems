    
class Solution {

    public int climbstairs (int N ,int[] dp){
        for(int i=0;i<=N;i++){
                 if(i<=1){
                    dp[i]=1;
                    continue;
                 }
                
                    dp[i] =dp[i-1] + dp[i-2];
                 
        }
            return dp[N];
    }
        
    
    public int climbStairs(int n) {
            int[] dp = new int[n+1];
           return climbstairs(n,dp);
    }
}