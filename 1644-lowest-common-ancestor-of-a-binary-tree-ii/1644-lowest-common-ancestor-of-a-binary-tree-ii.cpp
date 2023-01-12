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
    //to track if both p and q are found in tree
    int totalFound = 0;
    TreeNode* LCA(TreeNode* node,int p ,int q) {
         //Base case
        if(!node) return NULL;
        //left and right recursive call of faith asking if p or q is present in subtree
        TreeNode* leftFound = LCA(node->left,p,q);
        TreeNode* rightFound = LCA(node->right,p,q);
        //if current node is equal to p or q
        if(node->val == p || node->val == q) {
            totalFound++;
            return node;
        }
        // if p q are found in left and right then i am the LCA ill return myself
        if(leftFound != NULL && rightFound != NULL) {
            return node;
        }
         //return statement covering all the 3 cases of leftF,!rightF | rightF,!leftF | !leftF,!rightF
        return leftFound != NULL ? leftFound : rightFound;
    }
   
    
    
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        TreeNode* ans = LCA(root,p->val,q->val);
        //onlyy if both p and q are found in my overall tree then ill return lca or else the
        //returned lca is a fake one.
        return totalFound == 2 ? ans : NULL;
    }
};