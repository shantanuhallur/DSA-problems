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
    bool areEqualSubtrees(TreeNode* r1,TreeNode* r2) {
        if(!r1 && !r2) return true;
        if(!r1 || !r2) return false;
        if(r1->val != r2->val) return false;
        
        bool lAns = areEqualSubtrees(r1->left,r2->left);
        bool rAns = areEqualSubtrees(r1->right,r2->right);
        
        return lAns&&rAns;
    }

    bool isSubtree(TreeNode* root, TreeNode* subRoot) {
        if(!root) return false;
        
        if(root->val == subRoot->val) {
            bool ans = areEqualSubtrees(root,subRoot);
            if(ans) return true;
        }
        
        bool leftAns = isSubtree(root->left,subRoot);
        bool rightAns = isSubtree(root->right,subRoot);
        
        return leftAns || rightAns;
    }
};