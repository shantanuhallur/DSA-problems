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
    
    int rangeSum = 0;
    void rangeSumBST_01(TreeNode* root, int low, int high) {
        if(root == nullptr) return;
        
        if(root->val >= low && root->val<= high) {
            rangeSum += root->val;
        }
        
        if(root->val >= low) {
            rangeSumBST_01(root->left,low,high);
        }
        
        if(root->val <= high) {
            rangeSumBST_01(root->right,low,high);
        }
    }
    int rangeSumBST(TreeNode* root, int low, int high) {
        rangeSumBST_01(root,low,high);
        return rangeSum;
    }
};