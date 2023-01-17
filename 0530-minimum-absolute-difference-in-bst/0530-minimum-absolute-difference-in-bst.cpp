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
    TreeNode* prev = NULL;
    int minDiff = 1e8;
    void inOrder(TreeNode* node) {
        //Base Case
        if(!node) return;
        //Left and right recursive calls
        inOrder(node->left);
        //INORDER AREA ---->>>
        //minimize abs diff if needed
        if(prev) {
            if(node->val - prev->val < minDiff) minDiff = node->val - prev->val;
        }
        prev = node;
        //INORDER AREA ---->>>
        inOrder(node->right);
        
    }
    
    int getMinimumDifference(TreeNode* root) {
        inOrder(root);
        return minDiff;
    }
};