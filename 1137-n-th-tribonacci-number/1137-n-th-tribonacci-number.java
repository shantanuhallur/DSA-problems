class Solution {
    private int tribonacci(int n,int[] dp){
        if(n<=2) return dp[n] = n==0?0:1;
        
        if(dp[n]!=0){
            return dp[n];
        }
        
        return dp[n] = tribonacci(n-1,dp) + tribonacci(n-2,dp) + tribonacci(n-3,dp);
        
    }
    private int tribonacci_tabu(int N,int[] dp){
        for(int n=0 ; n<=N;n++){
            if(n<=2){
               dp[n] = n==0?0:1;
                continue;
            } 
        
         dp[n] = tribonacci(n-1,dp) + tribonacci(n-2,dp) + tribonacci(n-3,dp);
        }
        
        return dp[N];
    }
    
    public int tribonacci(int n) {
        int[]dp = new int[n+1];
        //return tribonacci(n,dp);
        
        return tribonacci_tabu(n,dp);
        
        
    }
}