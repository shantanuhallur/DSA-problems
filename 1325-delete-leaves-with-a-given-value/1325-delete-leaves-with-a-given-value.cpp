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
    TreeNode* removeLeafNodes(TreeNode* node, int target) {
        //Base Case
        if(!node) return nullptr;
        //Recursive Calls
        node->left = removeLeafNodes(node->left,target);
        node->right = removeLeafNodes(node->right,target);
        //Checking the condition of Leafs
        if(!node->left && !node->right && node->val == target) return nullptr;
        
        return node;
    }
};