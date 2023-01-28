class Solution {
    
int solveMemo(int n,int[] nums,int curr,int prev,int[][] dp ) {
        if(curr==n) return 0; 
        if(dp[curr][prev+1] != -1) return dp[curr][prev+1];
        //Include
        int take = 0;
        if(prev == -1 || nums[curr]>nums[prev])
        take = 1+ solveMemo(n,nums,curr+1,curr,dp);
        
        //exclude
        int notTake = 0 + solveMemo(n,nums,curr+1,prev,dp);
        
        return dp[curr][prev+1] = Math.max(take,notTake);
    }  
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int i=0;i<n;i++) {
            for(int j=-1;j<n;j++) {
                dp[i][j+1] = -1;
            }
        }
        return solveMemo(n,nums,0,-1,dp);
    }
}