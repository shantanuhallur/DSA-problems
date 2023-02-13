class Solution {
    int[][] dp;
    public int getA(int c, int level) {
        //pruning
        if(c>=5) return 0;
        //baseCase
        if(level==0) return 1;
        //cache check
        if(dp[c][level]!=-1) return dp[c][level];
        //compute
        int ans = 0;
        //pick alphabet
        ans+= getA(c,level-1);
        //not pick alphabet
        ans+= getA(c+1,level);    
        //save and return
        return dp[c][level] = ans;
    }
    public int countVowelStrings(int n) {
        dp = new int[5][n+1];
        for(int i=0;i<5;i++) {
            for(int j=0;j<n+1;j++){
                dp[i][j] = -1;
            }
        }
        return getA(0,n);
    }
}