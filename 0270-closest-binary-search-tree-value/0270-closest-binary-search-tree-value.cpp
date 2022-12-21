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
    int closestVal = -1;
    double minDiff = 1e10;
    
    void closestValue_01(TreeNode* node, double target) {
        if(abs(node->val - target) < minDiff) {
            minDiff = abs(node->val - target);
            closestVal = node->val;
        }
        
        if(node->left != nullptr) {
            closestValue_01(node->left,target);
        }
        
        if(node->right != nullptr) {
            closestValue_01(node->right,target);
        }
        
    }
    
    int closestValue(TreeNode* root, double target) {
        closestValue_01(root,target);
        return closestVal;
    }
};