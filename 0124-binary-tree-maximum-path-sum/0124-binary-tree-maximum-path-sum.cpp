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
    int ans =-1001;
    int getMaxPath(TreeNode* node) {
        //Base Case
        if(!node) return 0;
        //left and right Recursive calls which will return maxPathSum through respective child nodes
        int l = getMaxPath(node->left);
        int r = getMaxPath(node->right);
        //prepare return val (MPS for my parent which passes from any left or right chilf to me)
        int maxPathSumTillMe = max(max(l,r)+node->val,node->val);
        int maxPathValueForMyNode = max(maxPathSumTillMe,l+r+node->val);
        //maximize if this is the global maximum path sum;
        ans = max(ans,maxPathValueForMyNode);
        return maxPathSumTillMe;
    }
        
    int maxPathSum(TreeNode* root) {
        if(root==NULL) return 0;
        cout<<getMaxPath(root);
        return ans;
    }
};