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
    void recoverTree_01(TreeNode* curr) {
        if(!curr) return;
        
        //Left Recursive Call
        recoverTree_01(curr->left);
        //INORDER ------->>>>>>>
        //condition
        if(prev != nullptr && prev->val > curr->val) {
            b = curr;
            if(a==nullptr) a = prev;
        }
        //update prev so that we can move our previous ahead.
        prev = curr;
        //INORDER ------->>>>>>>
        //Right Recursive Call
        recoverTree_01(curr->right);
    }
    
    void recoverTree(TreeNode* root) {
        recoverTree_01(root);
        //SWAPPING
        int temp = a->val;
        a->val = b->val;
        b->val = temp;
    }
};