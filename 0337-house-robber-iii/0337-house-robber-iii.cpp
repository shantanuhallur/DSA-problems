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
    //isRobbed,notRobbed
    pair<int,int> getMaxRob(TreeNode* node) {
        if(!node) return {0,0};
        
        pair leftAns = getMaxRob(node->left);
        pair rightAns = getMaxRob(node->right);
        pair myAns = {0,0};
        //isRob
        myAns.first = leftAns.second+rightAns.second+node->val;
        //notRob
        myAns.second = max(leftAns.first,leftAns.second) + max(rightAns.first,rightAns.second);
        
        return myAns;
    }
    int rob(TreeNode* root) {
        pair rootAns = getMaxRob(root);
        return max(rootAns.first,rootAns.second);
    }
};