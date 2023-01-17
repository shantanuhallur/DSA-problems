class Solution {
//     public void dfs(int currNo , int n,List<Integer> ans) {
//         // if(currNo > n) return;
        
//         ans.add(currNo);
//         for(int j=0;j<10;j++) {
//             if(currNo*10+j<=n)
//             dfs(currNo*10 +j,n,ans);
//         }
//     }
    
//     public List<Integer> lexicalOrder(int n) {
//         List<Integer> ans = new ArrayList<>();
//         for(int i=1;i<=n;i++) {
//             dfs(i,n,ans);
//         }
//         return ans;
//     }
        public void dfs(int curr,int n, List<Integer> list){
        if(curr>n)
            return;
        list.add(curr);
        for(int i=0;i<10;i++)
            dfs(10*curr+i,n,list);
    }
    
    
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=9;i++)
            dfs(i,n,list);
        
        return list;
        
    }
}