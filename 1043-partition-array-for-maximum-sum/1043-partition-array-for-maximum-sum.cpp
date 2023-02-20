class Solution {
public:
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        int n = arr.size();
        vector<int>dp(n);
        dp[0] = arr[0];
        for(int i=1;i<n;i++) {
            int maxEle = 0;
            int maxOfAll = 0;
            for(int j=i;j>=max(0,i-k+1);j--) {
                maxEle = max(maxEle,arr[j]);
                if(j>0) {
                    maxOfAll = max(maxOfAll,(i-j+1)*maxEle+dp[j-1]);
                }
                else {
                    maxOfAll = max(maxOfAll,(i-j+1)*maxEle);
                }
            }
            dp[i] = maxOfAll;
        }
        return dp[n-1];
    }
};