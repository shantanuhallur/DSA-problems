class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] prev_idx = new int[n];
//         for(int i=0;i<n;i++) {
//             dp[i] = 1;
            
//         }
        int OmaxLen = 0; int idx = -1;
        for(int i=0;i<n;i++) {
            prev_idx[i] = -1;
            int maxLen =0;
            for(int j=0;j<i;j++) {
                if(nums[i]%nums[j]==0 && dp[j]+1>maxLen) {
                    maxLen = dp[j];
                    prev_idx[i] = j;
                }
            }
            dp[i] = maxLen+1;
            if(OmaxLen<dp[i]) {
                OmaxLen = dp[i];
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