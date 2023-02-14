class Solution {
    int[] dp;
    
    public boolean getWin(int x) {
        //base case
        if(x<=0) return false;
        //chache check
        if(dp[x]!=-1) return true;
        //compute
        boolean ans = false;
        for(int i=1;i<x;i++) {
            if(x%i==0 && !getWin(x-i)) ans = true;
        }
        if(ans) dp[x] = 1;
        return ans;
    }
    public boolean divisorGame(int n) {
        dp = new int[n+1];
        for(int i=0;i<n+1;i++) dp[i] = -1;
        return getWin(n);
    }
}