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
    TreeNode* getLCA(TreeNode* node,int p,int q) {
        if(!node) return nullptr;
        if(node->val == p || node->val == q) return node;
        
        TreeNode* left = getLCA(node->left,p,q);
        TreeNode* right = getLCA(node->right,p,q);
        
        if(left && right) return node;
        
        return (left ? left : right);
    }
    int kDown(TreeNode* node,int val,int len) {
        if(!node) return 0;
        if(node->val == val) return len;
        
        int left = kDown(node->left,val,len+1);
        if(left>0) return left;
        int right = kDown(node->right,val,len+1);
        if(right>0) return right;
        
        return (left+right);
    }
    int findDistance(TreeNode* root, int p, int q) {
        if(p==q) return 0;
        
        TreeNode* LCA = getLCA(root,p,q);
        cout<<LCA->val;
        int leftLen = kDown(LCA,p,0);
        int rightLen = kDown(LCA,q,0);
        cout<<leftLen<<rightLen;
        return leftLen+rightLen;
    }
};