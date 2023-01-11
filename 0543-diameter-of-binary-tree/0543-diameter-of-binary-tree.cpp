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
    //first carries left max diameter not passing through root
    //second carries length till nodes left;
    pair<int,int> dia(TreeNode* node) {
        if(!node) return {-1,-1};
            
        pair leftAns = dia(node->left);
        pair rightAns = dia(node->right);
        
        pair myAns = {-1,-1};
        myAns.first = max(max(leftAns.first,rightAns.first),leftAns.second+rightAns.second+2); 
        //for passing through my node ma of left and right dia , max of passing through my node
        myAns.second = max(leftAns.second,rightAns.second) + 1; //max height from node
        
        return myAns;
    }
    int diameterOfBinaryTree(TreeNode* root) {
        if(!root) return 0;
        return dia(root).first;
    }
};