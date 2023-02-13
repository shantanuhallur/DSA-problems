class Solution {
public:
    int getA(int level,int c,vector<vector<int>>& dp) {
        //pruning
        if(c>=5) return 0;
        //baseCase
        if(level==0) return 1;
        //cache check
        if(dp[level][c]!=-1) return dp[level][c];
        //compute
        int ans = 0;
        //pick alphabet
        ans+= getA(level-1,c,dp);
        //not pick alphabet
        ans+= getA(level,c+1,dp);    
        //save and return
        return dp[level][c] = ans;
    }
    int countVowelStrings(int n) {
        vector<vector<int>>dp(n+1,vector<int>(5,-1));
        for(int i=0;i<n+1;i++) {
            for(int j=0;j<5;j++){
                dp[i][j] = -1;
            }
        }
        return getA(n,0,dp);
    }
};