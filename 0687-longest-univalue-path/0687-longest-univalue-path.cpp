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
    int ans = 0;
    
    int dfs(TreeNode* node) {
        if(!node) return 0;
        
        int l = dfs(node->left);
        int r = dfs(node->right);
        
        if(node->left && node->left->val == node->val) l +=1;
        else l=0;
        
        if(node->right && node->right->val == node->val) r+=1;
        else r=0;
        ans = max(ans,l+r);
        return max(l,r);
    }
    int longestUnivaluePath(TreeNode* root) {
        dfs(root);
        return ans;
    }
};