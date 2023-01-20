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
    int ans = 0;
    int getDia(TreeNode* node) {
        if(!node) return -1;
        
        int l = getDia(node->left);
        int r = getDia(node->right);
        int diaTillmyNode = max(l,r)+1;
        int potentialMaxDia = max(diaTillmyNode,l+r+2);
        ans = max(ans,potentialMaxDia);
        return diaTillmyNode;
    }
    int diameterOfBinaryTree(TreeNode* root) {
        if(!root) return 0;
        getDia(root);
        return ans;
    }
};