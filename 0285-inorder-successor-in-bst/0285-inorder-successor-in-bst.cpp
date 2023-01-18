/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* ans = NULL;
    TreeNode* prev = NULL;
    void inOrder(TreeNode* node, TreeNode* p) {
        if(!node) return;
        
        inOrder(node->left,p);
        
        if(prev && prev == p) ans = node;
        
        prev = node;
        inOrder(node->right,p);
    }
    TreeNode* inorderSuccessor(TreeNode* root, TreeNode* p) {
        inOrder(root,p);
        return ans;
    }
};