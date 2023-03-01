class Solution {
    boolean[][] dp;
//     public boolean subsetSum(int[] nums,int n,int sum) {
        
//         if()
//     }
    public boolean canPartition(int[] nums) {
        int numSum =0;
        for(int i=0;i<nums.length;i++) {
            numSum += nums[i];
        }
        if(numSum%2!=0) return false;
        dp = new boolean[nums.length+1][(numSum/2)+1];
        
        int col =0;
        for(int row = 0 ; row<dp.length;row++) {
            dp[row][col] = true;
        }
        
        for(int i=1;i<dp.length;i++) {
            for(int j=1;j<dp[0].length;j++) {
                if(nums[i-1]<=j) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length][numSum/2];
        // return subsetSum(nums,nums.length,numSum/2);
    }
}