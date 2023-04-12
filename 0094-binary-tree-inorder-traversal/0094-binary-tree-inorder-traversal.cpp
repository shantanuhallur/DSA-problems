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
    void inorderTraversal_01(TreeNode* node,vector<int>& ans) {
        //Base Case
        if(node == nullptr) return;
        
        //Left Recursive Call
        inorderTraversal_01(node->left,ans);
        // INORDER ------>>>>
        
        ans.push_back(node->val);
        
        
        // INORDER ------>>>>
        //Right Recursive Call
        inorderTraversal_01(node->right,ans);
    }
    
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> ans;
        inorderTraversal_01(root,ans);
        return ans;
    }
};