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
        
        int leftH = height(node->left);
        int rightH = height(node->right);
        
        return max(leftH,rightH) + 1;
    }
    TreeNode* lcaDeepestLeaves(TreeNode* root) {
        if(root == nullptr) return nullptr;
        
        int leftSubTree = height(root->left);
        
        int rightSubTree = height(root->right);
        
        if(leftSubTree == rightSubTree) return root;
        
        else if(leftSubTree < rightSubTree) {
            return lcaDeepestLeaves(root->right);
        }
        else{
            return lcaDeepestLeaves(root->left);
        }
    }
};