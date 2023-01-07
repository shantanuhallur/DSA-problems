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
    double maxAvg =-1;
    pair<double,double> avge(TreeNode* node) {
        if(!node) return {0,0};
        
        pair leftP = avge(node->left);
        pair rightP = avge(node->right);
        
        pair myP = {0,0};
        myP.first = leftP.first + rightP.first + node->val;
        myP.second = leftP.second + rightP.second + 1;
        
        if((double)myP.first/myP.second > maxAvg) maxAvg = (double)myP.first/(double)myP.second;
        
        return myP;
    }
    double maximumAverageSubtree(TreeNode* root) {
        avge(root);
        return maxAvg;
    }
};