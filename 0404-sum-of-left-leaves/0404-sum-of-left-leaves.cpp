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
    int sum = 0;
    void sumOfLeftLeaves_01(TreeNode* node) {
        //Base Case for return
        if(!node) return;
        //Checking if left child exists and of its a leaf then adding it to the sum.
        if(node->left && !node->left->left && !node->left->right) sum += node->left->val;
        
        //Recursively add the left leaves sum for current nodes left and right.
        sumOfLeftLeaves_01(node->left);
        sumOfLeftLeaves_01(node->right);
    }
    int sumOfLeftLeaves(TreeNode* root) {
        sumOfLeftLeaves_01(root);
        return sum;
    }
};