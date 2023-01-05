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
    TreeNode* prev = nullptr;
    int sum = 0;
    void convert(TreeNode* node) {
        if(!node) return;
        
        convert(node->right);
        node->val += sum; 
        sum = node->val;
        prev = node;
        convert(node->left);
    }
    
    TreeNode* bstToGst(TreeNode* root) {
        convert(root);
        return root;
    }
};