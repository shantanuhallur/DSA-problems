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
    int tilt = 0;
    int findTilt_01(TreeNode* node) {
        //Base Case 
        if(node == nullptr) return 0;
        
        //get Left subtree sumation
        int leftSumation = findTilt_01(node->left);
        
        //get Right subtree sumation
        int rightSumation = findTilt_01(node->right);
        
        tilt += abs(leftSumation-rightSumation);
        
        int sum = (leftSumation + rightSumation + node->val);
        
        return sum;
    }
    int findTilt(TreeNode* root) {
        
        findTilt_01(root);
        
        return tilt;
    }
};