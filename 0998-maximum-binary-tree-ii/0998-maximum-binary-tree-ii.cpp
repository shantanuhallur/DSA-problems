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
    TreeNode* insertIntoMaxTree(TreeNode* root, int val) {
        //Base Case
        if(!root) return new TreeNode(val);
        
        //if val is greater than the current root.val then it should be attached to right of this new root.
        if(root->val<val) return new TreeNode(val,root,nullptr);
        //recursive call to find the real position of val if the about if condition does not apply.
        root->right = insertIntoMaxTree(root->right,val);
        //just return our newly modified trees root.
        return root;
    }
};