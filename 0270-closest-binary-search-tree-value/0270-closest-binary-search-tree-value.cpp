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
    int closestValue(TreeNode* root, double target) {
        int val,closestN  = root->val;
        
        while(root != nullptr) {
            val = root->val;
            closestN = abs(val-target) < abs(closestN-target) ? val : closestN;
            if(target < root->val) root = root->left;
            else root = root->right;
        }
        
        return closestN;
    }
};