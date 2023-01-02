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
        //Base Case
        if(!node) return 0;
        
        //recursive faith of call of left and right height
        int leftH = height(node->left);
        int rightH = height(node->right);
        //Calculate meri height
        return max(leftH,rightH) +1;
    }
    TreeNode* subtreeWithAllDeepest(TreeNode* root) {
        //Base case
        if(!root) return nullptr;
        //get max depth of left and right subtrees
        int leftSubTreeH = height(root->left);
        int rightSubTreeH = height(root->right);
        //check our cases conditions to conclude where we want to search for our subtree
        if(leftSubTreeH==rightSubTreeH) return root;
        else if(leftSubTreeH<rightSubTreeH) return subtreeWithAllDeepest(root->right);
        else return subtreeWithAllDeepest(root->left);
        
    }
};