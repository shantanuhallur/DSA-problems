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
    int minDiff = INT_MAX;
    TreeNode* prev = nullptr;
     void minDiffInBST_01(TreeNode* node) {
        //Base Case 
         if(node == nullptr) return;
         
         //Left Recursive Call
         minDiffInBST_01(node->left);
         //INORDER AREA ---->>>>>>>>>>>>
         
         if(prev != nullptr) {
             int minVal = node->val - prev->val;
             minDiff = min(minDiff,minVal);
         }
         
         prev = node;
         //INORDER AREA ---->>>>>>>>>>>>
         //Right Recursive Call
         minDiffInBST_01(node->right);
         
         
         
    }
    int minDiffInBST(TreeNode* root) {
        minDiffInBST_01(root);
        return minDiff;
    }
};