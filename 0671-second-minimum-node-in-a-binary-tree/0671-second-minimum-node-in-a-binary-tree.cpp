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
        if(!root) return -1;
        
        if(!root->left && !root->right) return -1;
        
        int leftMin = root->left->val;
        int rightMin = root->right->val;
        
        if(root->left->val == root->val)leftMin = findSecondMinimumValue(root->left);
        if(root->right->val == root->val)rightMin = findSecondMinimumValue(root->right);
            
        if(leftMin!= -1 && rightMin !=-1) {
            return min(leftMin,rightMin);
        }
        else if(leftMin != -1) {
            return leftMin;
        }
        else return rightMin;
    }
};