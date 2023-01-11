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
    // first = max diameter second =max height
    pair<int,int> getAns(TreeNode* node) {
        if(!node) return {-1,-1};
        
        pair leftAns = getAns(node->left);
        pair rightAns = getAns(node->right);
        
        pair myAns = {-1,-1};
        int diaThorughMe = (leftAns.second + rightAns.second) + 2;
        
        myAns.second =  max(leftAns.second,rightAns.second)+1;
      
        myAns.first =   max(max(leftAns.first,rightAns.first),diaThorughMe);
        
        return myAns;
    }
    int diameterOfBinaryTree(TreeNode* root) {
        return getAns(root).first;
    }
};