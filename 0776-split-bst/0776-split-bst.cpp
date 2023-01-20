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
    vector<TreeNode*> splitBST(TreeNode* root, int target) {
        vector<TreeNode*> res(2);
        if(!root) return{NULL,NULL};
        
        if(root->val <= target) {
            res[0] = root;
            vector<TreeNode*> rAns = splitBST(root->right,target);
            root->right = rAns[0];
            res[1] = rAns[1];
        }
        else {
            res[1] = root;
            vector<TreeNode*> lAns = splitBST(root->left,target);
            root->left = lAns[1];
            res[0] = lAns[0];
        }
        return res;
    }
};