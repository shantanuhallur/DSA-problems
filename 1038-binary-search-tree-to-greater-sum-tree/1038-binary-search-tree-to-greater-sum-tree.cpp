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
    int currSum = 0;
    void bstToGst_01(TreeNode* node) {
        if(!node) return;
        
        bstToGst_01(node->right);
        
        currSum += node->val;
        node->val = currSum;
        
        prev = node;
        bstToGst_01(node->left);
    }
    TreeNode* bstToGst(TreeNode* root) {
        bstToGst_01(root);
        return root;
    }
};