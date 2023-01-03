class Solution {
public:
    int numberOfNodes(int n, vector<int>& queries) {
        vector<int> dp(n+1,0);
        //save toggle of parent nodes
        for(int query : queries) dp[query]++;
        //get cumulative toggle of ith lable node
        int result = 0;
        for(int i=1;i<=n;i++){
            
           if(i!=1) dp[i] += dp[i/2];//as i/2th is the parent of this ith child
            
           if(dp[i]%2 ==1)result++; //get see if current node is toggled odd number of times if yes then add in result
        }
        return result;
    }
};