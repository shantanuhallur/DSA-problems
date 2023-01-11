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
    //Base Case
    //Recursive left and right call of faith
    //when my current node is roobed
    //when my current node is not robbed
    //PAIR {isRobbed , notRobbed}
    pair<int,int> getMaxMoney(TreeNode* node) {
        //Base Case
        if(!node) return {0,0};
        
        pair myAns =  {0,0};
        //Recursive left and right call of faith
        pair leftAns = getMaxMoney(node->left);
        pair rightAns = getMaxMoney(node->right);
        //when my current node is robbed
        myAns.first = node->val + leftAns.second + rightAns.second;
        //when my current node is not robbed
        myAns.second = max(leftAns.first,leftAns.second) +
                       max(rightAns.first,rightAns.second);
        
        return myAns;
    }
    
    int rob(TreeNode* root) {
        pair rootP = getMaxMoney(root);
            cout<<rootP.second;
        return max(rootP.first,rootP.second);
    }
};