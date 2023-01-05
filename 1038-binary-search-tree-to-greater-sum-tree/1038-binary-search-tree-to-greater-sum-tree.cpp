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
    int greaterSum = 0;
    TreeNode* prev = nullptr;
    void convert(TreeNode* node) {
        //base case
        if(!node) return;
        
        //RIGHT DFS CALL then left call
        convert(node->right);
        //INORDER AREA----->>>>>
        node->val += greaterSum;
        greaterSum = node->val;
        //update prev to node in recursive stack.
        prev = node;
        //INORDER AREA----->>>>>
        convert(node->left);
    }
    TreeNode* bstToGst(TreeNode* root) {
        convert(root);
        return root;
    }
};