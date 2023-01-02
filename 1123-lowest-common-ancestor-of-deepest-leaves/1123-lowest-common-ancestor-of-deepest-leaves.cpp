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
    int height(TreeNode* node) {
        if(!node) return 0;
        
        int leftHeight = height(node->left);
        int rightHeight = height(node->right);
        
        return max(leftHeight,rightHeight) + 1;
    }
    TreeNode* lcaDeepestLeaves(TreeNode* root) {
        if(!root) return nullptr;
        
        int leftSubtreeHeight = height(root->left);
        int rightSubtreeHeight = height(root->right);
        
        if(leftSubtreeHeight == rightSubtreeHeight) return root;
        
        else if(leftSubtreeHeight > rightSubtreeHeight)
            return lcaDeepestLeaves (root->left);
        else return lcaDeepestLeaves(root->right);
    }
};