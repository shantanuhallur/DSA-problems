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
    //<isRob,notRob>
    pair<int,int> getMaxMoney(TreeNode* node) {
        //Base Case
        if(!node) return {0,0};
        
        pair leftAns = getMaxMoney(node->left);
        pair rightAns = getMaxMoney(node->right);
        
        pair myAns = {0,0};
        myAns.first = node->val + leftAns.second + rightAns.second;
        myAns.second = max(leftAns.first,leftAns.second) + max(rightAns.first,rightAns.second);
        
        return myAns;
    }
    
    int rob(TreeNode* root) {
        pair rootAns = getMaxMoney(root);
        return max(rootAns.first,rootAns.second);
    }
};