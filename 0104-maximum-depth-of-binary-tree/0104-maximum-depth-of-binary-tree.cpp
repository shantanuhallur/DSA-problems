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
    int maxDepth(TreeNode* root) {
        //Base Case
        if(root == nullptr) return 0;
        //Left and Right recurvise calls.
        int leftDepth = maxDepth(root->left);
        int rightDepth =  maxDepth(root->right); 
        //returning the maximum chosen depth + 1.
        return max(leftDepth,rightDepth) + 1;
    }
};