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
    //PAIR --> {SUM , totalNodes}
    double maxAvg = 0;
    pair<double,int> getAvg(TreeNode* node) {
        //base case
        if(!node) return {0,0};
        //left and right right recursive call
        pair leftAns = getAvg(node->left);
        pair rightAns = getAvg(node->right);
        //postOrderArea ---->>
        pair myAns = {0,0};        
    //total sum of my subtree
        myAns.first = leftAns.first + rightAns.first + node->val;
    //total nodes in my whole subtree
        myAns.second = leftAns.second + rightAns.second + 1;
    //maximuze Avg
        if(maxAvg< (double) myAns.first/myAns.second) maxAvg = (double) myAns.first/myAns.second;
        
        return myAns;
    }
    double maximumAverageSubtree(TreeNode* root) {
        getAvg(root);
        return maxAvg;
    }
};