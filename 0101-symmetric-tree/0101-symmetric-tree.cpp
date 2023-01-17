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
    bool symmetric(TreeNode* lnode,TreeNode* rnode) {
        if(!lnode && !rnode) return true;
        if(!lnode || !rnode) return false;
        if(lnode->val != rnode->val) return false;
        
        if(!symmetric(lnode->left,rnode->right)) return false;
        if(!symmetric(lnode->right,rnode->left)) return false;
        
        return true;
    }
    bool isSymmetric(TreeNode* root) {
        if(!root) return true;
        return symmetric(root->left,root->right);
    }
};