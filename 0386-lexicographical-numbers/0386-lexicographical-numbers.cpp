class Solution {
public:
    void dfs(int currNo,int n,vector<int>& ans) {
         if(currNo>n) return;
        
        ans.push_back(currNo);
        for(int j=0;j<=9;j++) {
            if(currNo*10+j<=n)dfs(currNo*10+j,n,ans);
        }
    }
    vector<int> lexicalOrder(int n) {
        vector<int> ans;
        for(int i=1;i<=9;i++) {
            dfs(i,n,ans);
        }
        return ans;
    }
};