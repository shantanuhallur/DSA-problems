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
    bool getSymmetric(TreeNode* fNode,TreeNode* sNode) {
        //if both nodes dont exist in this pos we return true;
        if(!fNode && !sNode) return true;
        //if even one of them is null return false
        if(!fNode || !sNode) return false;
        //if both nodes exist but with different values we return false
        if(fNode->val != sNode->val) return false;
        //check bottom nodes if symmetric or not with right position
        if(!getSymmetric(fNode->left,sNode->right)) return false;
        if(!getSymmetric(fNode->right,sNode->left)) return false;
        //else the treee is symmetric
        return true;
    }
    bool isSymmetric(TreeNode* root) {
        //Base Case
        if(!root) return true;
        return getSymmetric(root->left,root->right);
    }
};