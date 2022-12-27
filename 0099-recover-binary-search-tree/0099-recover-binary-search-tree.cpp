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
    TreeNode* a = nullptr;
    TreeNode* b = nullptr;
    void recoverTree_01(TreeNode* node) {
        if(!node) return;
        
        recoverTree_01(node->left);
        
        if(prev!=nullptr && prev->val > node->val) {
            b = node;
            if(a==nullptr) a = prev;
        }
        
        prev = node;
        recoverTree_01(node->right);
    }
    void recoverTree(TreeNode* root) {
        recoverTree_01(root);
        int temp = a->val;
        a->val = b->val;
        b->val = temp;
    }
};