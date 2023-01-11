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
    // PAIR.FIRST = max DIAMETER , PAIR.SECOND = MAX HEIGHT;
    //Base Case 
    //recursive left and right calls
    //Calculate diameter through my node
    //my answers max diameter
    //my answers max height
    pair<int,int> getDia(TreeNode* node) {
        //Base Case
        if(!node) return {-1,-1};
        
        pair myAns = {-1,-1};
        //recursive left and right calls
        pair leftAns = getDia(node->left);
        pair rightAns = getDia(node->right);
        //Calculate diameter through my node
        int diaMyNode = leftAns.second + rightAns.second + 2;
        //my answers max diameter
        myAns.first = max(max(leftAns.first,rightAns.first),diaMyNode);
        //my answers max height
        myAns.second = max(leftAns.second,rightAns.second) + 1;
        
        return myAns;
    }
    
    int diameterOfBinaryTree(TreeNode* root) {
        return getDia(root).first;
    }
};