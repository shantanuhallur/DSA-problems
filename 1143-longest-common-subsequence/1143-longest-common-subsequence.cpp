class Solution {
public:
    int t[1001][1001];
    int LCS(string& x,string& y,int m,int n) {
        if(m==0 || n==0) return 0;
        if(t[m][n]!=-1) return t[m][n];
        
        if(x[m-1]==y[n-1]) {
            return t[m][n] = 1 + LCS(x,y,m-1,n-1);
        }
        else {
            return t[m][n] = max(LCS(x,y,m,n-1),LCS(x,y,m-1,n));
        }
    }
    
    int longestCommonSubsequence(string text1, string text2) {
        memset(t,-1,sizeof(t));
        return LCS(text1,text2,text1.length(),text2.length());
    }
};