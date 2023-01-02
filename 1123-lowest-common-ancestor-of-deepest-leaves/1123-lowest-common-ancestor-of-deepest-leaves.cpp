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
    int height(TreeNode* node) {
        //base case
        if(!node) return 0;
        //recursive faith of left and right node
        int leftH = height(node->left);
        int rightH = height(node->right);
        //calculate current node's height
        return max(leftH,rightH) + 1;
    }
    TreeNode* lcaDeepestLeaves(TreeNode* root) {
        //Base Case
        if(root==nullptr) return nullptr;
        
        //get left and right subtrees height
        int leftSubtreeH = height(root->left);
        int rightSubtreeH = height(root->right);
        
        //check our 3 CASES
        if(leftSubtreeH==rightSubtreeH) {
            return root; // current node is our LCA
        }
        else if(leftSubtreeH < rightSubtreeH) {
            return lcaDeepestLeaves(root->right);
        }
        else{
            return lcaDeepestLeaves(root->left);
        }
    }
};