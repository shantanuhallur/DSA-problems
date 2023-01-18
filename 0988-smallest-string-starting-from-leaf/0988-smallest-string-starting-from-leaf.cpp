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
    string ans = "";
    
    void getString(TreeNode* node,string s) {
        char sub = (char)('a' + node->val);
        s = sub + s;
        if(node->left == NULL && node->right == NULL) {
            if(ans == "") {
                ans = s;
            }
            else {
                ans = min(s,ans);
            }
        }
        if(node->left!=NULL) getString(node->left,s);
        if(node->right!=NULL) getString(node->right,s);
    }
    string smallestFromLeaf(TreeNode* root) {
        getString(root,"");
        return ans;
    }
};