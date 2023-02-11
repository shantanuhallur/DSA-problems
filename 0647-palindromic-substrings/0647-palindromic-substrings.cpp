class Solution {
public:
    int countSubstrings(string s) {
        vector<vector<bool>> dp(s.size(),vector<bool>(s.size(),false));
        int count =0;
        
        for(int gap=0;gap<s.size();gap++) {
            for(int i=0,j=gap; j<s.size();i++,j++) {
                if(gap==0) {
                    dp[i][j] = true;
                }
                else if (gap==1) {
                    dp[i][j] = s[i]==s[j];
                }
                else {
                    if(s[i]==s[j] && dp[i+1][j-1]) {
                        dp[i][j] = true;
                    }
                }
                if(dp[i][j]) count++;
            }
        }
        return count;
    }
};