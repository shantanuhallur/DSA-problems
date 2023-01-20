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
    
    int getTillChildSum(TreeNode* node) {
        if(!node) return 0;
        int l = getTillChildSum(node->left);
        int r = getTillChildSum(node->right);
        int maxTillmyNode = max(max(l,r) +node->val , node->val);
        int maxThroughtMyNode = max(maxTillmyNode,l+r+node->val);    
        ans= max(ans,maxThroughtMyNode);
        return maxTillmyNode;
    }
    int maxPathSum(TreeNode* root) {
        getTillChildSum(root);
        return ans;
    }
};