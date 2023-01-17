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
    int getHeight(TreeNode* node) {
        //Base case Null node
        if(!node) return 0;
        //left & right recursive call
        int leftH = getHeight(node->left);
        if(leftH==-1) return -1;
        int rightH = getHeight(node->right);
        if(rightH == -1) return -1;
        //check if left and right height is balanced for my node
        if(abs(leftH-rightH)>1) return -1;
        //return the height for this node to parent node;
        return max(leftH,rightH) +1;
    }
    bool isBalanced(TreeNode* root) {
        if(!root) return true;
        if(getHeight(root) == -1) return false;
        return true;
    }
};