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
    int getHeight(TreeNode* node) {
        if(!node) return 0;
        
        int leftH = getHeight(node->left);
        if(leftH==-1) return -1;
        
        int rightH = getHeight(node->right);
        if(rightH==-1) return -1;
        
        if(abs(leftH-rightH) > 1) return -1;
        
        return max(leftH,rightH) + 1;
    }
    
    bool isBalanced(TreeNode* root) {
        if(!root) return true;
        if(getHeight(root)==-1) return false;
        return true;
    }
};