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
    bool isBST = true;
    TreeNode* prev = nullptr;
    void traverseInorder(TreeNode* node) {
        //Base case
        if(!node) return;
        //preorder area
        //Left recursive Call
        traverseInorder(node->left);
        //INORDER AREA --->>>>
        //check condition
        if(prev && prev->val >= node->val) isBST = false;
        //update prev
        prev = node;
        //INORDER AREA --->>>>
        //Right recursive call
        traverseInorder(node->right);
        //posorder area
    }
    bool isValidBST(TreeNode* root) {
        traverseInorder(root);
        return isBST;
    }
};