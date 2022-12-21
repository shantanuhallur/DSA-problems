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
    void postorderTraversal_01(TreeNode* node,vector<int>& ans) {
        //Base Case
        if(node == nullptr) return;
        
        //Left Recursive Call
        postorderTraversal_01(node->left,ans);
        // INORDER ------>>>>
        // INORDER ------>>>>
        //Right Recursive Call
        postorderTraversal_01(node->right,ans);
        
         ans.push_back(node->val);
    }
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> ans;
        postorderTraversal_01(root,ans);
        return ans;
    }
};