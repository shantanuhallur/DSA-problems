class Solution {
    public void dfs(int currNo , int n,List<Integer> ans) {
         if(currNo > n) return;
        
        ans.add(currNo);
        for(int j=0;j<10;j++) {
            if(currNo*10+j<=n) dfs(currNo*10 +j,n,ans);
        }
    }
    
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        for(int i=1;i<=9;i++) {
            dfs(i,n,ans);
        }
        return ans;
    }
}