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
    TreeNode* getTargetCopy(TreeNode* cloned, TreeNode* target) {
        if(cloned==nullptr) return new TreeNode();
        
        if(cloned->val == target->val){
            return cloned;
        }
        
        if(cloned->left != nullptr){
            TreeNode* left = getTargetCopy(cloned->left,target);
            if(left->val == target->val)return left;
        }
        
        if(cloned->right != nullptr){
            TreeNode* right = getTargetCopy(cloned->right,target);
            if(right->val == target->val)return right;
        }
        
        return new TreeNode();
    }
    
    TreeNode* getTargetCopy(TreeNode* original, TreeNode* cloned, TreeNode* target) {
        TreeNode* ans = getTargetCopy(cloned,target);
        return ans;
    }
};