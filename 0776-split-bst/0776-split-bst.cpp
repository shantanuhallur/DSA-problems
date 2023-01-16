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
        vector<TreeNode*> result(2,NULL);
        if(!root) return result;
        
        if(root->val <= target) {
            result[0] = root;
            vector<TreeNode*> rightSubTree = splitBST(root->right,target);
            root->right = rightSubTree[0];
            result[1] =rightSubTree[1];
        }
        else {
            result[1] = root;
            vector<TreeNode*> leftSubTree = splitBST(root->left,target); 
            root->left = leftSubTree[1];
            result[0] =  leftSubTree[0];
        }
        return result;
    }
};