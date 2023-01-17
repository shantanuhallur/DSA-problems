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
    TreeNode* prev = NULL;
    int minN = 1e8;
    void getAns(TreeNode* node) {
        if(!node) return;
        
        getAns(node->left);
        if(prev!= NULL) {
            if(node->val - prev->val < minN) minN = node->val - prev->val; 
        }
        prev = node;
        getAns(node->right);
    }
    int getMinimumDifference(TreeNode* root) {
        getAns(root);
        return minN;
    }
};