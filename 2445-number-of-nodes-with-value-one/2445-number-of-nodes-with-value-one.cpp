class Solution {
public:
    int numberOfNodes(int n, vector<int>& queries) {
        vector<int> dp(n+1,0);
        int on =0;
        for(int query : queries) dp[query] ^=1;
        
        for(int i=1;i<n+1;i++) {
            if(i!=1) {
                dp[i] ^= dp[i/2];
            }
            if(dp[i]%2==1) on++;
        }
        return on;
    }
};