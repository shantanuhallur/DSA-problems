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
    void rangeSumBST_01(TreeNode* node, int low, int high) {
        //Base condition
        if(node == nullptr) return;
        // If current value is in range
        if(low <= node->val && node->val <= high) rangeSum += node->val;
        //Check if we want to recurse to left or right
        if(low<= node->val) rangeSumBST_01(node->left,low,high);
        
        if(node->val <= high) rangeSumBST_01(node->right,low,high);
        
    }
    
    int rangeSumBST(TreeNode* root, int low, int high) {
        rangeSumBST_01(root,low,high);
        return rangeSum;
    }
};