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
        //base case 
        if(node->val == target->val) return node;
        
        //left Recursive
        if(node->left != nullptr) {
            TreeNode* leftAns = getTargetCopy_01(node->left, target);
            if(leftAns->val == target->val) return leftAns;
        }
        
        //right Recursive
        if(node->right != nullptr) {
            TreeNode* rightAns = getTargetCopy_01(node->right, target);
            if(rightAns->val == target->val) return rightAns;
        }

        return new TreeNode(-1);
    }
    
    TreeNode* getTargetCopy(TreeNode* original, TreeNode* cloned, TreeNode* target) {
        TreeNode* ans = getTargetCopy_01(cloned,target);
        return ans;
    }
};