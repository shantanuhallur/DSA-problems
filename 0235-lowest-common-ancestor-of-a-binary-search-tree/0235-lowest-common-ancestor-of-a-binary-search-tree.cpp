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
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        TreeNode* curr = root;
        
        while(curr) {
            //IF our curr is smaller go to right subtree
            if(curr->val < p->val && curr->val < q->val) {
                curr = curr->right;
            }
            // If our  curr is greater go to left subtree
            else if (curr->val > p->val && curr->val > q->val) {
                curr = curr->left;
            }
            else return curr;   
        }
        return curr;
    }
};