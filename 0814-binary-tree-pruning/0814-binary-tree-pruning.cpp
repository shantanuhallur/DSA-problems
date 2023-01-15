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
    bool modifyTree(TreeNode* node) {
        //Base Case if node is null no node exists with value as 1
        if(!node) return false;
        //left and right recursive calls
        bool leftContains1 = modifyTree(node->left);
        bool rightContains1 = modifyTree(node->right);
        //if there exists no node with value 1 in my left and right subtree ill prune it.
        if(!leftContains1) node->left = NULL;
        if(!rightContains1) node->right = NULL;
        
        return leftContains1||rightContains1||node->val == 1;
    }
    TreeNode* pruneTree(TreeNode* root) {
        if(!root) return NULL;
        modifyTree(root);
        //check if root itself has been pruned to a leaf and its val is 0 if yes prune it.
        if(!root->left && !root->right && root->val==0) return NULL;
        return root;
    }
};