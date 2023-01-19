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
    int i=0;
    bool dfs(TreeNode* node,vector<int>& v,vector<int>& ans) {
        if(!node) return true;
        if(node->val != v[i++]) return false;
        if(node->left && node->left->val != v[i]) {
            ans.push_back(node->val);
            return dfs(node->right,v,ans) && dfs(node->left,v,ans);
        }
        return dfs(node->left,v,ans) && dfs(node->right,v,ans);
    }
    vector<int> flipMatchVoyage(TreeNode* root, vector<int>& voyage) {
        vector<int> ans;
        return dfs(root,voyage,ans) ? ans : vector<int>{-1};
    }
};