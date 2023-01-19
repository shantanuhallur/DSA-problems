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
    //gloabal  ans which hold LUP in whole tree
    int ans = 0;
    int getLUP(TreeNode* node) {
        //Base Case
        if(node == NULL) return 0;
        //left and right recursive call of faith -> get me LUP throught MY L&R CHILD
        int l = getLUP(node->left);
        int r = getLUP(node->right);
        
        if(node->left && node->left->val == node->val) l+=1;
        else l=0;
        
        if(node->right && node->right->val == node->val) r+=1;
        else r =0;
        //Maximize ans's LUP
        ans = max(ans,l+r);
        //return value will be as per our faith the max UVP THROUGH MY ROOT NODE
        return max(l,r);
    }
    int longestUnivaluePath(TreeNode* root) {
        getLUP(root);
        return ans;
    }
};