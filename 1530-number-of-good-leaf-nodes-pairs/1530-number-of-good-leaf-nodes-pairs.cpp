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
    
    vector<int> getPairs(TreeNode* node, int d) {
        if(!node) return {};
        if(!node->left && !node->right) return {1};
        
        vector<int> lAns = getPairs(node->left,d);
        vector<int> rAns = getPairs(node->right,d);
        
        for(int val1 : lAns) {
            for(int val2 : rAns) {
                if(val1 + val2 <= d) count++;
            }
        }
        int n = lAns.size() , m = rAns.size();
        
        vector<int> myAns(n+m,0);
        int i = 0;
        for(int val : lAns) myAns[i++] = val+1;
        for(int val : rAns) myAns[i++] = val+1;
        
        return myAns;
    }
    int countPairs(TreeNode* root, int distance) {
        getPairs(root,distance);
        return count;
    }
};