class Solution {
    public int numberOfNodes(int n, int[] queries) {
        int[] dp = new int[n+1];
        //save toggle of parent nodes
        for(int query : queries) {
            dp[query]++;
        }
        
        int result = 0;
        for(int i=1;i<=n;i++) {
            //get cumulative toggle of ith lable node
            if(i!=1) dp[i] += dp[i/2]; //as i/2th is the parent of this ith child
            
            //get see if current node is toggled odd number of times if yes then add in result
            if(dp[i]%2 ==1) result++;
        }
        
        return result;
    }
}