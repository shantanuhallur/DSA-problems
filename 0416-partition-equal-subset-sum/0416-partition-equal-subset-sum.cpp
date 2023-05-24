class Solution {
     boolean[][] val;
     int[][] dp;
    boolean getAns(int[] arr, int n, int sum) {
        if(n==0 || sum==0) {
            if(n==0 && sum==0){
                dp[n][sum] = 1;
                return val[n][sum] = true;
            }
            else if (n==0) {
                dp[n][sum] = 1;
                return val[n][sum] = false;
            }
            else {
                dp[n][sum] = 1;
                return val[n][sum] = true;
            }
             
        }
        if(dp[n][sum] != -1) return val[n][sum];
            
        if(arr[n-1]<=sum) {
            val[n][sum] = getAns(arr,n-1,sum-arr[n-1]) || getAns(arr,n-1,sum);
            dp[n][sum] = 1;
        }
        else {
             val[n][sum] = getAns(arr,n-1,sum);
             dp[n][sum] = 1;
        }
        return val[n][sum];
    }
    public boolean canPartition(int[] nums) {
        int numSum =0;
        for(int i=0;i<nums.length;i++) {
            numSum += nums[i];
        }
        if(numSum%2!=0) return false;
        
        int n = nums.length;
        int sum = numSum/2;
        // int col =0;
        // for(int row = 0 ; row<dp.length;row++) {
        //     dp[row][col] = true;
        // }
        val = new boolean[n+1][sum+1];
        dp = new int[n+1][sum+1];
        for(int i=0;i<n+1;i++) {
            for(int j=0;j<sum+1;j++) {
                // if(i==0) {
                //     dp[i][j] = 1;
                //     val[i][j] = false;
                // }
                // else{
                //     dp[i][j] = -1;
                // }
                
                // if(j==0) {
                //     dp[i][j] = 1;
                //     val[i][j] = true;
                // }
                // else {
                //     dp[i][j] = -1;
                // }
                dp[i][j] = -1;
            }
        }
        return getAns(nums,n,sum);
        
        // for(int i=1;i<dp.length;i++) {
        //     for(int j=1;j<dp[0].length;j++) {
        //         if(nums[i-1]<=j) {
        //             dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
        //         }
        //         else {
        //             dp[i][j] = dp[i-1][j];
        //         }
        //     }
        // }
        // return dp[nums.length][numSum/2];
        // return subsetSum(nums,nums.length,numSum/2);
    }
}