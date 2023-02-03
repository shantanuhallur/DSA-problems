class Solution {
    int[][] t = new int[1001][1001];
    int LCS(String x,String y,int m,int n) {
        if(m==0 || n==0) return 0;
        if(t[m][n]!=-1) return t[m][n];
        
        if(x.charAt(m-1)==y.charAt(n-1)) {
            return t[m][n] = 1 + LCS(x,y,m-1,n-1);
        }
        else {
            return t[m][n] = Math.max(LCS(x,y,m,n-1),LCS(x,y,m-1,n));
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        for(int i=0;i<t.length;i++) {
            for(int j=0;j<t[0].length;j++) {
                t[i][j] = -1;
            }
        }
        return LCS(text1,text2,text1.length(),text2.length());
    }
}