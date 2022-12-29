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
    int sumEvenGrandparent_01(TreeNode* node) {
        int leftSum = 0;
        int rightSum = 0;
        int mySum = 0;
        
        if(node->left) leftSum +=  sumEvenGrandparent_01(node->left);
        
        if(node->right) rightSum +=  sumEvenGrandparent_01(node->right);
        
        if(node->val % 2 == 0) {
            if(node->left && node->left->left) mySum += node->left->left->val;
            
            if(node->left && node->left->right) mySum += node->left->right->val;
            
            if(node->right && node->right->left) mySum += node->right->left->val;
            
            if(node->right && node->right->right) mySum += node->right->right->val;
        }
        
        return leftSum+rightSum+mySum;
    }
    
    int sumEvenGrandparent(TreeNode* root) {
        return sumEvenGrandparent_01(root);
    }
};