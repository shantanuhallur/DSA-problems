class Solution {
    //momoization
    private int minCostClimbingStairs(int[] cost , int[] dp, int n){
       if(n<=1){
           return dp[n] = cost[n];
       }
        if(dp[n]!=0) return dp[n]; 

        int fcall = minCostClimbingStairs(cost,dp,n-1);
        int scall = minCostClimbingStairs(cost,dp,n-2);   
        int ans = Math.min(fcall,scall) + (n==cost.length?0:cost[n]);
         
        return dp[n] = ans;
    }
    
     private int minCostClimbingStairs_tabu(int[] cost , int[] dp, int N){
         for(int n=0;n<=N;n++){
             if(n<=1){
                dp[n] = cost[n];
                 continue;
             }

        int fcall = dp[n-1];
        int scall = dp[n-2];   
        int ans = Math.min(fcall,scall) + (n==cost.length?0:cost[n]);
         
         dp[n] = ans;
         }
         
         return dp[N];
     }
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int [cost.length+1];
       return minCostClimbingStairs_tabu(cost,dp,cost.length);
    }
}