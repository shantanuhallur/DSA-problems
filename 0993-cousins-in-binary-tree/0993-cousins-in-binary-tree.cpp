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
    int par = -1;
    int getDepth(TreeNode* node,int depth,int target) {
        if(node->val == target) return depth;
        
        if(node->left) {
            if(node->left->val == target) par = node->val;
            int lAns = getDepth(node->left,depth+1,target);
            if(lAns != 0) return lAns;
        }
        
        if(node->right) {
            if(node->right->val == target) par = node->val;
            int rAns = getDepth(node->right,depth+1,target);
            if(rAns !=0) return rAns;
        }
        return 0;
    }
    bool isCousins(TreeNode* root, int x, int y) {
        int depth1 = getDepth(root,0,x);
        int par1 = par;
        par = -1;
        int depth2 = getDepth(root,0,y);
        int par2 = par;
        
        return depth1 == depth2 && par1 != par2 ? true : false; 
    }
};