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
    TreeNode* dummy = new TreeNode(-1);
    TreeNode* prev = dummy;
    
    void increasingBST_01(TreeNode* node) {
        if(node == nullptr) return;
        increasingBST_01(node->left);
        
        prev->right = node;
        
        node->left = nullptr;
        
        prev = node;
        
        increasingBST_01(node->right);
        
    }
    
    TreeNode* increasingBST(TreeNode* root) {
        increasingBST_01(root);
        return dummy->right;
    }
};