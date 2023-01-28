class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] prev_idx = new int[n];
        for(int i=0;i<n;i++) {
            dp[i] = 1;
            prev_idx[i] = -1;
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(nums[i]%nums[j]==0) {
                    if(dp[j]+1 > dp[i]) {
                        dp[i] = dp[j]+1;
                        prev_idx[i] = j;
                    }
                }
            }
        }
        int maxLis = 0; int idx = -1;
        for(int i=0;i<n;i++) {
            if(maxLis<dp[i]) {
                maxLis = dp[i];
                idx = i;
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        while(idx!=-1) {
            ans.add(nums[idx]);
            idx = prev_idx[idx];
        }
        return ans;
    }
}