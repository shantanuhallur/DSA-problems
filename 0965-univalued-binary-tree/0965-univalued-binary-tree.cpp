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
    bool isUnivalTree_01(TreeNode* node,int val) {
        if(node == nullptr) return true;
        
        bool hasLeft = isUnivalTree_01(node->left,val);
        bool hasRight = isUnivalTree_01(node->right,val);
        
        if(hasLeft && hasRight && node->val == val) return true;
        else return false;
    }
    bool isUnivalTree(TreeNode* root) {
        if(root == nullptr) return true;
        int val = root->val;
        return isUnivalTree_01(root,val);
    }
};