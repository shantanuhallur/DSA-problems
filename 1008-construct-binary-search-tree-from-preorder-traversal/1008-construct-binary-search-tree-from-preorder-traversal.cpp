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
    int idx = 0;
    TreeNode* buildBST(vector<int>& preorder,int lRange,int rRange) {
        //Base Case
        if(idx > preorder.size()-1 || preorder[idx] < lRange || preorder[idx]>rRange) return nullptr;
        //Root node of Preorder Tree
        TreeNode* root = new TreeNode(preorder[idx++]);
        //Left & Right recursive Faith Call's
        root->left = buildBST(preorder,lRange,root->val);
        root->right = buildBST(preorder,root->val,rRange);
        
        return root;
    }
    TreeNode* bstFromPreorder(vector<int>& preorder) {
        return buildBST(preorder,-1,1001);
    }
};