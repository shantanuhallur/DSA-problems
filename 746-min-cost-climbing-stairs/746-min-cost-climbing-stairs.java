class Solution {
    
    private int minCostClimbingStairs(int[] cost , int[] dp, int n){
        if(n<=1){
            return dp[n] = cost[n];
        }
        if(dp[n]!=0){
            return dp[n];
        }
            
            
          int fcall = minCostClimbingStairs(cost,dp,n-1);
          int scall = minCostClimbingStairs(cost,dp,n-2);
        
         dp[n] = Math.min(fcall,scall) ;
        if(n<cost.length){
            dp[n]+=cost[n]; //cost of getting jumped on last stair is 0;
        }
        return dp[n];
    }
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int [cost.length+1];
       return minCostClimbingStairs(cost,dp,cost.length);
    }
}