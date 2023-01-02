class Solution {
public:
    int numberOfNodes(int n, vector<int>& queries) {
        vector<int> nodes(n+1,0);
        
        for(int &query : queries) nodes[query] ^=1;
        
        int result = nodes[1];

        for (int i = 2; i <= n; i++) {
            nodes[i] ^= nodes[i / 2];
            result += nodes[i];
        }

        return result;
    }
};