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
    int avgNodeCount = 0;
    pair<int,int> averageOfSubtree_01(TreeNode* node) {
        if(!node->left && !node->right){
            avgNodeCount ++;
            return {node->val,1};
        }
        
        pair leftPair = {0,0};
        pair rightPair = {0,0};
        pair myPair = {0,0};
        
        if(node->left) leftPair = averageOfSubtree_01(node->left);
        
        if(node->right) rightPair = averageOfSubtree_01(node->right);
        
        myPair.first = leftPair.first + rightPair.first + node->val;
        myPair.second = leftPair.second + rightPair.second + 1;
        
        if(myPair.first / myPair.second == node->val) avgNodeCount++;
        
        return myPair;
    }
    int averageOfSubtree(TreeNode* root) {
        averageOfSubtree_01(root);
        return avgNodeCount;
    }
};