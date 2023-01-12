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
    // Parir -> sum ,totalNodes;
    double maxAvg =0;
    pair<double,int> getMax(TreeNode* node) {
        if(!node) return {0,0};
        
        pair leftAns = getMax(node->left);
        pair rightAns = getMax(node->right);
        pair myAns = {0,0};
        
        myAns.first = node->val + leftAns.first + rightAns.first;
        myAns.second = leftAns.second + rightAns.second +1;
        if((double)myAns.first/myAns.second > maxAvg) maxAvg =(double) myAns.first/myAns.second;
        
        return myAns;
    }
    double maximumAverageSubtree(TreeNode* root) {
        getMax(root);
        return maxAvg;
    }
};