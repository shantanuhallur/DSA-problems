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
    
    int getDepth(TreeNode* node, int depth, int num) {
        if(node->val == num) {
            return depth;
        }
        
        if(node->left != nullptr) {
            if(node->left->val == num) par = node->val;
            int leftAns = getDepth(node->left,depth+1,num);
            if(leftAns != 0) return leftAns;
        }
        
        if(node->right != nullptr) {
            if(node->right->val == num) par = node->val;
            int rightAns = getDepth(node->right,depth+1,num);
            if(rightAns != 0) return rightAns;
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