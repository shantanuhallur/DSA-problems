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
    int totalGoodNodes = 0;
    void goodNodes_01(TreeNode* node,int maxVal) {
        //Base Case
        if(!node) return;
        
        //Check if Good Node or Not
        if(node->val >= maxVal) {
            totalGoodNodes++;
            maxVal = node->val;
        }
        
        //Recursive Call
        goodNodes_01(node->left,maxVal);
        goodNodes_01(node->right,maxVal);
    }
    
    int goodNodes(TreeNode* root) {
        goodNodes_01(root,-(int)1e5);
        return totalGoodNodes;
    }
};