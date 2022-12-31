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
    int findSecondMinimumValue(TreeNode* root) {
        //Base case for null root
        if(!root) return -1;
        //Base Case for leaf nodes
        if(!root->left && !root->right) return -1;
        
        int leftSMin = root->left->val;
        int rightSMin = root->right->val;
        
        //Conditional Recursive Call
        if(root->val == root->left->val) leftSMin = findSecondMinimumValue(root->left);
        
        if(root->val == root->right->val) rightSMin = findSecondMinimumValue(root->right);
        
        if(leftSMin != -1 && rightSMin != -1){
            return min(leftSMin,rightSMin);
        }
        else if(leftSMin != -1) {
            return leftSMin;
        }
        else return rightSMin;
    }
};