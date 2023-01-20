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
    int getUVP(TreeNode* node,int val) {
        if(!node) return 0;
        
        int l = getUVP(node->left,node->val);
        int r = getUVP(node->right,node->val);
        ans = max(ans,l+r);
        return (node->val == val) ? max(l,r)+1 : 0;
    }
    int longestUnivaluePath(TreeNode* root) {
        getUVP(root,-1001);
        return ans;
    }
};