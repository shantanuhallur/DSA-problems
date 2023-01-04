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
    TreeNode* prev=nullptr;
    int csum =0;
    void convert(TreeNode* node) {
        if(!node) return;
        
        convert(node->right);
        
        csum += node->val;
        node->val = csum;
        
        prev = node;
        convert(node->left);
    }
    TreeNode* convertBST(TreeNode* root) {
        convert(root);
        return root;
    }
};