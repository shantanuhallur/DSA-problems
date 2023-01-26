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
     void formLeftBoundary(TreeNode* node,vector<int>& res) {
        if(!node) return;
        if(node->left) {
            res.push_back(node->val);
            formLeftBoundary(node->left,res);
        }
        else if(node->right) {
            res.push_back(node->val);
            formLeftBoundary(node->right,res);
        }
    }
    
     void formRightBoundary(TreeNode* node,vector<int>& res) {
        if(!node) return;
        if(node->right) {
            formRightBoundary(node->right,res);
            res.push_back(node->val);
        }
        else if(node->left) {
            formRightBoundary(node->left,res);
            res.push_back(node->val);
        }
    }
    void addLeaves(TreeNode* node,vector<int>& res) {
        if(!node) return;
        addLeaves(node->left,res);
        if(!node->left && !node->right)res.push_back(node->val);
        addLeaves(node->right,res);
    }
    vector<int> boundaryOfBinaryTree(TreeNode* root) {
        vector<int> res;
        if(!root) return res;
        res.push_back(root->val);
        formLeftBoundary(root->left,res);
        addLeaves(root->left,res);
        addLeaves(root->right,res);
        formRightBoundary(root->right,res);
        return res;
    }
};