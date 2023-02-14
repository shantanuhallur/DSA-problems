class Solution {
    boolean[] dp;
    
    public boolean getWin(int x) {
        //base case
        if(x<=0) return false;
        //chache check
        if(dp[x]) return dp[x];
        //compute
        boolean ans = false;
        for(int i=1;i<x;i++) {
            if(x%i==0 && !getWin(x-i)) ans = true;
        }
        return dp[x] = ans;
    }
    public boolean divisorGame(int n) {
        dp = new boolean[n+1];
        return getWin(n);
    }
}