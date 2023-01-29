class Solution {
public:
    int findLongestChain(vector<vector<int>>& pairs) {
        sort(pairs.begin(),pairs.end());
        int longestChain = 1;
        int n = pairs.size();
        vector<int> lis(n,1);
        for(int i =0;i<n;i++) {
            lis[i] = 1;
            for(int j=0;j<i;j++) {
                if(pairs[j][1]<pairs[i][0] && lis[j]+1>lis[i]) {
                    lis[i] = lis[j]+1;
                    longestChain = max(lis[i],longestChain);
                }
            }
        }
        return longestChain;
    }
};