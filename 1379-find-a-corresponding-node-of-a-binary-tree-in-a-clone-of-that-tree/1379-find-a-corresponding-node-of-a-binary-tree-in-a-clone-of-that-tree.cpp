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
    
    TreeNode* getTargetCopy_01(TreeNode* node, TreeNode* target) {
        
        // if node.val == target.val
        if(node->val == target->val) return node;
        
        //Recursive call for left
        if(node->left != nullptr) {
            TreeNode* left = getTargetCopy_01(node->left,target);
            if(left->val == target->val) return left;
        }
        
        //Recursive call for right
        if(node->right != nullptr) {
            TreeNode* right = getTargetCopy_01(node->right,target);
            if(right->val == target->val) return right;
        }
        
        return new TreeNode(-1);
    }
    
    TreeNode* getTargetCopy(TreeNode* original, TreeNode* cloned, TreeNode* target) {
        TreeNode* ans = getTargetCopy_01(cloned,target);
        return ans;
    }
};