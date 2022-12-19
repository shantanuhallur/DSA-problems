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
    int evaluateTree_01(TreeNode* root) {
        
        if(root->left == nullptr && root->right == nullptr) {
            return root->val;
        }
        int operation = 0;
        int left = 0;
        int right = 0;
        
        if(root->left != nullptr) {
            left = evaluateTree_01(root->left);
        }
        
        if(root->right != nullptr) {
            right = evaluateTree_01(root->right);
        }
        
        //OR operation
        if(root-> val == 2) {
            operation = (left | right);
        }
        
        //AND operation
        if(root-> val == 3) {
            operation = (left & right);
        }
        
        root->val = operation;
        return root->val;
       
    }
    bool evaluateTree(TreeNode* root) {
        int ans = evaluateTree_01(root);
        
        return ans == 1 ? true : false;
    }
};