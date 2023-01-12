/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    
    int found=0;
    TreeNode* LCA(TreeNode* node, int p, int q) {
        if(node == NULL) return node;
        
        TreeNode* leftFound = LCA(node->left,p,q);
        TreeNode* rightFound = LCA(node->right,p,q);
        
        if(node->val == p || node->val == q) {
            found++;
            return node;
        }
        
        if(leftFound && rightFound) return node;
        
        return leftFound != NULL ? leftFound : rightFound;
    }
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        TreeNode* ans = LCA(root,p->val,q->val);
        return found == 2 ? ans : NULL;
    }
};