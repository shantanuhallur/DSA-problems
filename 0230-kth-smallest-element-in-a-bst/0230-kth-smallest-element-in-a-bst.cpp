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
    TreeNode* prev = nullptr;
    void inOrder(TreeNode* node,vector<int>& arr) {
        if(node == nullptr) return;
        
        if(node->left!=nullptr) inOrder(node->left,arr);
        arr[0]--;
        if(arr[0]==0 && prev==nullptr) prev = node;
        
        if(node->right!=nullptr) inOrder(node->right,arr);
    }
    int kthSmallest(TreeNode* root, int k) {
        vector<int> arr(1,k);
        inOrder(root,arr);
        return prev->val;
    }
};