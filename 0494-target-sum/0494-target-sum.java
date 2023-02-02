class Solution {
    int countSS(int[]nums,int sum,int noOfZeros) {
        int n = nums.length;
        int[][] dp = new int[n+1][sum+1];
        for(int row =0;row<n+1;row++) {
            for(int col = 0;col<sum+1;col++) {
                if(row == 0) {
                    dp[row][col] = 0;
                }
                if(col == 0) {
                    dp[row][col] = 1;
                }
            }
        }
        
        for(int i=1;i<n+1;i++) {
            for(int j=1;j<sum+1;j++) {
                if(nums[i-1]==0) {
                    dp[i][j] = dp[i-1][j];
                }
                else if(nums[i-1]<=j) {
                    dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return (int)Math.pow(2,noOfZeros)*dp[n][sum];
    }
    
    public int findTargetSumWays(int[] nums, int target) {
         if (nums.length == 1) {

            if (Math.abs(nums[0]) == Math.abs(target)) return 1;
            else
                return 0;
        }
        
        int arrSum =0, noOfZeros = 0;
        for(int i=0;i<nums.length;i++) {
            arrSum += nums[i];
            if(nums[i] == 0) noOfZeros++;
        } 
        if((arrSum+target)%2==1) return 0;
        int sumForCountOfSS = (target + arrSum)/2;
        if(sumForCountOfSS<0) return 0;
        return countSS(nums,sumForCountOfSS,noOfZeros);
    }
}