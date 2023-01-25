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
    TreeNode* getTree(TreeNode* node, int limit) {
        if(!node) return NULL;
        if(!node->left && !node->right) return node->val < limit ? NULL : node;
        
        node->left = getTree(node->left,limit-node->val);
        node->right = getTree(node->right,limit-node->val);
        
        return node->left == node->right ? NULL : node;
    }
    TreeNode* sufficientSubset(TreeNode* root, int limit) {
        return getTree(root,limit);   
    }
};