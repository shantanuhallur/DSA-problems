class Solution {
    int[][] t = new int[1001][1001];
//     int LCS(String x,String y,int m,int n) {
//         if(m==0 || n==0) return 0;
//         if(t[m][n]!=-1) return t[m][n];
        
//         if(x.charAt(m-1)==y.charAt(n-1)) {
//             return t[m][n] = 1 + LCS(x,y,m-1,n-1);
//         }
//         else {
//             return t[m][n] = Math.max(LCS(x,y,m,n-1),LCS(x,y,m-1,n));
//         }
//     }
    public int longestCommonSubsequence(String text1, String text2) {
        for(int i=0;i<t.length;i++) {
            for(int j=0;j<t[0].length;j++) {
                if(i==0||j==0)t[i][j] = 0;
            }
        }
        int m = text1.length();
        int n = text2.length();
        for(int i=1;i<m+1;i++) {
            for(int j=1;j<n+1;j++) {
                if(text1.charAt(i-1)==text2.charAt(j-1)) {
                    t[i][j] = 1+t[i-1][j-1];
                }
                else {
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        return t[m][n];
    }
}