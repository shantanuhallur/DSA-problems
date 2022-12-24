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
    
    void goodNodes_01(TreeNode* root,int maxVal) {
        if(!root) return;
        
        if(root->val>=maxVal) {
            totalGoodNodes++;
            maxVal = root->val;
        }
        
        goodNodes_01(root->left,maxVal);
        goodNodes_01(root->right,maxVal);
    }
    
    int goodNodes(TreeNode* root) {
        if(!root) return 0;
        goodNodes_01(root,-(int)1e5);
        return totalGoodNodes;
    }
};