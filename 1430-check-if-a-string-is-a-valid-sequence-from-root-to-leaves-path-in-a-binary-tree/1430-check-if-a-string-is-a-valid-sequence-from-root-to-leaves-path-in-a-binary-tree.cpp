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
    bool isValid(TreeNode* node,vector<int>& arr,int idx) {
        if(!node || idx == arr.size()) return false;
        if(node->val != arr[idx]) return false;
        if(!node->left && !node->right && idx == arr.size()-1) return true;
        return isValid(node->left,arr,idx+1) || isValid(node->right,arr,idx+1);
    }
    bool isValidSequence(TreeNode* root, vector<int>& arr) {
        return isValid(root,arr,0);
    }
};