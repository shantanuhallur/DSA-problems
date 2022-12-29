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
    int minDepth_01(TreeNode* node) {
        if(!node->left && !node->right) return 1;
        
        int leftMinH = 1e6;
        int rightMinH = 1e6;
        
        if(node->left) leftMinH = minDepth_01(node->left);
        
        if(node->right) rightMinH = minDepth_01(node->right);
        
        return min(leftMinH,rightMinH) + 1;
    }
    
    int minDepth(TreeNode* root) {
        if(!root) return 0;
        int height = minDepth_01(root);
        return height;
    }
};