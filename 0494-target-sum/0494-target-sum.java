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
        // Each zero can be put in either of the partitions, so 2^z ways to do this
        return (int)Math.pow(2,noOfZeros)*dp[n][sum];
    }
    
    public int findTargetSumWays(int[] nums, int target) {
         if (nums.length == 1) {
            // Edge case when only one element is present in array
            if (Math.abs(nums[0]) == Math.abs(target)) return 1;
            else return 0;
        }
        // We will solve problem considering there is no zeroes in the input array, and we will deal with it in the last. To count the number of zeroes
        int arrSum =0, noOfZeros = 0;
        for(int i=0;i<nums.length;i++) {
            arrSum += nums[i];
            if(nums[i] == 0) noOfZeros++;
        } 
        // Because the sum of a subset can't be in decimals
        /*The above if condition is used because:
(sum-target)< 0 => When the target is more than the total sum, we can never reach that.*/
        if(arrSum<Math.abs(target)||(arrSum+target)%2==1) return 0;
        // This is the given sum, of which we have to find the number of count of               subsets with sum equal to given sum
        int sumForCountOfSS = (target + arrSum)/2;
        // Since we are dealing with only positive integers, so sum of a subset can't           be negative
        //if(sumForCountOfSS<0) return 0; WE CAN NEVER REACH THIS COUNT WITH ALL THE SUM
        return countSS(nums,sumForCountOfSS,noOfZeros);
    }
}