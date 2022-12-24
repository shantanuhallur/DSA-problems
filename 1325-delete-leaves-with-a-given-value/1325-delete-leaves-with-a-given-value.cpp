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
    TreeNode* removeLeafNodes_01(TreeNode* root, int target) {
        if(root == nullptr) return nullptr;
        
        root->left = removeLeafNodes_01(root->left,target);
        
        root->right = removeLeafNodes_01(root->right,target);
        
        if(root->left == nullptr && root->right == nullptr && root->val == target) return nullptr;
        else return root;
    }
    
    TreeNode* removeLeafNodes(TreeNode* root, int target) {
        if(root == nullptr || (root->val == target && root->left == nullptr && root->right == nullptr)) return nullptr;
      
        return removeLeafNodes_01(root,target);
    }
};