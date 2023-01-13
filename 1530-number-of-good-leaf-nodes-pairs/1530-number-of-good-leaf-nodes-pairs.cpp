/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int count = 0;
    
    vector<int> getPair(TreeNode* node,int d) {
        if(!node) return {};
        if(!node->left && !node->right) {
            return {1};
        }
        
        vector<int> lAns = getPair(node->left,d);
        vector<int> rAns = getPair(node->right,d);
        
        int n = lAns.size(); int m = rAns.size();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(lAns[i]+rAns[j] <=d) count++;
            }
        }
        
        vector<int> res(m+n,0);
        int i=0;
        for(int val : lAns) res[i++] = val+1;
        for(int val : rAns) res[i++] = val+1;
        
        return res;
    }
    
    int countPairs(TreeNode* root, int distance) {
        getPair(root,distance);
        return count;
    }
};