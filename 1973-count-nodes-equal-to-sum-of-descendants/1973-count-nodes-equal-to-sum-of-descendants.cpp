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
    int totalN = 0;
    int count(TreeNode* node) {
        if(!node) return 0;
        
        long leftSum = count(node->left);
        long rightSum = count(node->right);
        
        if(leftSum + rightSum == node->val) totalN++;
        
        return rightSum+leftSum+node->val;
    }
    int equalToDescendants(TreeNode* root) {
        count(root);
        return totalN;
    }
};