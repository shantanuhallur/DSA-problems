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
    int countN=0;
    int equalToDescendants_01(TreeNode* node) {
        //Base case 
        if(!node) return 0;
        
        //left & right sum
        long leftSum = equalToDescendants_01(node->left);
        long rightSum = equalToDescendants_01(node->right);
        //check condition
        if(leftSum+rightSum == node->val) countN++;
        //return current cumulative sum to our nodes parent
        return leftSum + rightSum + node->val;
    }
    int equalToDescendants(TreeNode* root) {
        equalToDescendants_01(root);
        return countN;
    }
};