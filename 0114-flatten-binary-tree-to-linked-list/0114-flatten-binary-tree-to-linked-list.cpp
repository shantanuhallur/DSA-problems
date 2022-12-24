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
    
    TreeNode* flatten_01(TreeNode* node) {
        if(!node || (!node->left && !node->right)) return node;
        
        TreeNode* leftTail = flatten_01(node->left);
        TreeNode* rightTail = flatten_01(node->right);
        
        if(leftTail!=nullptr){
            leftTail->right = node->right;
            node->right = node->left;
            node->left = nullptr;
        }
        
        return rightTail != nullptr? rightTail : leftTail;
    }
        
    void flatten(TreeNode* node) {
        flatten_01(node);
    }
};