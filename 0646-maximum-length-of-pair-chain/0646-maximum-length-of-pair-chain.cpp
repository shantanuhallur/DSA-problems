class Solution {
public:
    int findLongestChain(vector<vector<int>>& pairs) {
        sort(pairs.begin(),pairs.end(),[](vector<int>&a,vector<int>&b){
            return a[1]<b[1];
        });
        int ans=0;
        int curr = -1001;
        for(int i=0;i<pairs.size();i++) {
            if(pairs[i][0]>curr) {
                curr = pairs[i][1];
                ans++;
            }
        }
        return ans;
    }
};