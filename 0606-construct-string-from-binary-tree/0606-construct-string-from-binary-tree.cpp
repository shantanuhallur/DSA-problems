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
    string tree2str(TreeNode* root) {
        string ans = "";
        //left recursive call
        if(root->left) ans+= "(" + tree2str(root->left) + ")";
        //if left doesnt exist but right child does exist
        if(!root->left && root->right)  ans+= "()";
        //right recursive call
        if(root->right) ans+= "(" + tree2str(root->right) + ")";
        //append ans to my rootnode's val
        return to_string(root->val) + ans; 
    }
};