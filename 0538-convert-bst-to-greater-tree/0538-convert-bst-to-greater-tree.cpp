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
    int greaterSum=0;
    void traverse(TreeNode* node) {
        //base case
        if(!node) return;
        
        //right recursive call
        traverse(node->right);
        //Inorder area -->>>>
        node->val += greaterSum;
        
        greaterSum = node->val;
        //Inorder area -->>>>
        //left recursive call
        traverse(node->left);
    }
    TreeNode* convertBST(TreeNode* root) {
        traverse(root);
        return root;
    }
};