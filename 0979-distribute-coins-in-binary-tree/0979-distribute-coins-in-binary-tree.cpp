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
    int total=0;
    int distribute(TreeNode* node) {
        if(!node) return 0;
        
        int leftExDef = distribute(node->left);
        int rightExDef = distribute(node->right);
        
        total += abs(leftExDef) + abs(rightExDef);
        return leftExDef + rightExDef + node->val -1;
    }
    int distributeCoins(TreeNode* root) {
        distribute(root);
        return total;
    }
};