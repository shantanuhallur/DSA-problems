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
    int ancestor = -1;
    void diff(TreeNode* node,int minE,int maxE) {
        if(!node) return;
        
        minE = min(minE,node->val);
        maxE = max(maxE,node->val);
        
        ancestor = max(ancestor,abs(maxE-minE));
        
        diff(node->left,minE,maxE);
        diff(node->right,minE,maxE);
    }
    int maxAncestorDiff(TreeNode* root) {
        diff(root,root->val,root->val);
        return ancestor;
    }
};