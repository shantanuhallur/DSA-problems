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
    int sum = 0;
    void sumOfLeftLeaves_01(TreeNode* node) {
        if(!node) return;
        
        if(node->left && !node->left->left && !node->left->right) sum+= node->left->val;
        
        sumOfLeftLeaves_01(node->left);
        sumOfLeftLeaves_01(node->right);
    }
    int sumOfLeftLeaves(TreeNode* root) {
        if(!root) return 0;
        sumOfLeftLeaves_01(root);
        return sum;
    }
};