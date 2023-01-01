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
    int ancestor = -1;
    void maxAncestorDiff_01(TreeNode* node,int maxE,int minE) {
        //Base Case
        if(!node) return;
        
        //Maximize minE & maxE
        minE = min(minE,node->val);
        maxE = max(maxE,node->val);
        //Maximize our ancestor
        ancestor = max(ancestor,abs(maxE-minE));
        //Left and Right recursive Call
        maxAncestorDiff_01(node->left,maxE,minE);
        maxAncestorDiff_01(node->right,maxE,minE);
        
    }
    int maxAncestorDiff(TreeNode* root) {
        maxAncestorDiff_01(root,root->val,root->val);
        return ancestor;
    }
};