class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] prevIdx = new int[n];
         for(int i =0;i<n;i++) {
             dp[i]=1;
             prevIdx[i] = -1; 
         }
        for(int i=0;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(nums[i]%nums[j]==0) {
                    if(dp[j]+1>dp[i]) {
                        dp[i] = dp[j]+1;
                        prevIdx[i] = j;
                    }
                }
            }
        }
        int max = 0; int index= 0;
        for(int i=0;i<n;i++) {
            if(dp[i] > max) {
                 max = dp[i];
                 index = i;
            } 
        }
        List<Integer> ans = new ArrayList<>();
        while(index != -1) {
            ans.add(nums[index]);
            index = prevIdx[index];
        }
        return ans;
    }
}