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
    int ans = -1001;
    int getPathSum(TreeNode* node) {
        if(node ==NULL) return 0;
        
        int l = getPathSum(node->left);
        int r = getPathSum(node->right);
        
        int maxTillMyNode = max(max(l,r) + node->val,node->val);
        int maxThroughMyNode = max(maxTillMyNode,l+r+node->val);
        ans = max(ans,maxThroughMyNode);
        
        return maxTillMyNode;
    }
    int maxPathSum(TreeNode* root) {
        if(root==NULL) return 0;
        getPathSum(root);
        return ans;
    }
};