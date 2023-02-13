class Solution {
    int[][] dp;
    public int getA(int level,int c) {
        //pruning
        
        //baseCase
        if(level==0) return 1;
        //cache check
        if(dp[level][c]!=-1) return dp[level][c];
        //compute
        int ans = 0;
        //pick alphabet
        for(int ch=0;ch<5;ch++) {
            if(ch>=c) {
                ans+= getA(level-1,ch);
            }
        }   
        //save and return
        return dp[level][c] = ans;
    }
    public int countVowelStrings(int n) {
        dp = new int[n+1][5];
        for(int i=0;i<n+1;i++) {
            for(int j=0;j<5;j++){
                dp[i][j] = -1;
            }
        }
        return getA(n,0);
    }
}