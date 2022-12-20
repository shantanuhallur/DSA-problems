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
    TreeNode* dummy = new TreeNode(-1);
    TreeNode* prev = dummy;
    
    void makeBSTLinear(TreeNode* node) {
        //Base Case.
        if(node == nullptr) return;
        
        //Left Recursive Call
        makeBSTLinear(node->left);
        //INORDER ------>>>>
        
        //Make Current node's left null;
        node->left = nullptr;
        
        //Initialize prev right to node in Inorder
        prev->right = node;
        
        // Move Previous Ahead
        prev = node;
        //INORDER ------>>>>
        //Right Recursive Call
         makeBSTLinear(node->right);
    }
        
    TreeNode* increasingBST(TreeNode* root) {
        makeBSTLinear(root);
        return dummy->right;
    }
};