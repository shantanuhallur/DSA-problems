class Solution {
    public int LCS(String a,String b) {
        int m = a.length();
        int n = b.length();
        
        int[][] t = new int[m+1][n+1];
        for(int i=1;i<m+1;i++) {
            for(int j=1;j<n+1;j++) {
                if(a.charAt(i-1) == b.charAt(j-1)) {
                    t[i][j] = 1+t[i-1][j-1];  
                }
                else {
                    t[i][j] = Math.max(t[i][j-1],t[i-1][j]);
                }
            }
        }
        return t[m][n];
    }
    public int longestPalindromeSubseq(String s) {
        StringBuilder b = new StringBuilder();
        b.append(s);
        b.reverse();
        return LCS(s,b.toString());
    }
}