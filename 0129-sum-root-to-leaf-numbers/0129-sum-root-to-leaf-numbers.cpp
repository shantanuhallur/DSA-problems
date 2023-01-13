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
    int sum = 0;
    void getSum(TreeNode* node, int currSum) {
        if(!node) return;
        if(!node->left && !node->right) {
            currSum = currSum * 10 + node->val;
                sum+= currSum;
            return;
        }
        
        currSum = (int)currSum*10+node->val;
        getSum(node->left,currSum);
        getSum(node->right,currSum);
    }
    int sumNumbers(TreeNode* root) {
        getSum(root,0);
        return sum;
    }
};