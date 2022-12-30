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
    int idx =0;
    TreeNode* buildTree(vector<int>& preorder,int lrange,int rrange) {
        if(idx>preorder.size()-1 || preorder[idx] < lrange || preorder[idx] > rrange) return nullptr;
        
        TreeNode* root = new TreeNode(preorder[idx++]);
        
        root->left = buildTree(preorder,lrange,root->val);
        root->right = buildTree(preorder,root->val,rrange);
        
        return root;
    }
    
    TreeNode* bstFromPreorder(vector<int>& preorder) {
        TreeNode* root = buildTree(preorder,-1,10001);
        return root;
    }
};