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
    int maxLen = 1;
    
    void getMaxLen(TreeNode* node,int parVal,int pathLen) {
        if(!node) return;
        
        int currPathLen = 1;
        if(node->val - 1 == parVal) currPathLen += pathLen;
        if(maxLen<currPathLen) maxLen = currPathLen;
        getMaxLen(node->left,node->val,currPathLen);
        getMaxLen(node->right,node->val,currPathLen);
    }
    int longestConsecutive(TreeNode* root) {
        if(!root) return 0;
        getMaxLen(root,root->val-1,0);
        return maxLen;
    }
};