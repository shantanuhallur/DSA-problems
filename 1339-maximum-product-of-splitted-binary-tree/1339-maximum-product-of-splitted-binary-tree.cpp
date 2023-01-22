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
    int mod = 1000000007;
    long maxi = 0;
    long total=0;
    int convertTree(TreeNode* node) {
        if(!node) return 0;
        return node->val += convertTree(node->left) + convertTree(node->right);
    }  
    void traverse(TreeNode* node) {
        if(!node) return;
        traverse(node->right);
        traverse(node->left);
        maxi = max(node->val*(total-node->val),maxi);
    }
    int maxProduct(TreeNode* root) {
        this->total = convertTree(root);   
        traverse(root);
        return (int)(maxi%mod);
    }
};