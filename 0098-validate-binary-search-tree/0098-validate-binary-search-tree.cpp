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
    bool isBTree = true;
    TreeNode* prev = nullptr;
    void isValidBST_01(TreeNode* root) {
        if(!root) return;
        
        isValidBST_01(root->left);
        if(prev!= nullptr && prev->val >= root->val) isBTree = false;
        prev = root;
        isValidBST_01(root->right);
    }
    bool isValidBST(TreeNode* root) {
        isValidBST_01(root);
        return isBTree;
    }
};