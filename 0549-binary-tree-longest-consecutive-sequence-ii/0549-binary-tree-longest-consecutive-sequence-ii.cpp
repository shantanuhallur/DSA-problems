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
    //pair{inc,dec}
    int maxLen = -1;
    pair<int,int> getLCS(TreeNode* node) {
        if(!node) return {0,0};
        
        int leftInc = 1 , leftDec = 1;
        int rightInc = 1 , rightDec = 1;
        if(node->left) {
            pair lAns = getLCS(node->left);
            if(node->val == node->left->val +1) {
                leftInc = lAns.first + 1;
            }
            else if(node->val +1 == node->left->val) {
                leftDec = lAns.second +1;
            }
        }
        
        if(node->right) {
            pair rAns = getLCS(node->right);
            if(node->val == node->right->val +1) {
                rightInc = rAns.first +1;
            }
            else if(node->val + 1 == node->right->val) {
                rightDec = rAns.second + 1;
            } 
        }
        
        int maxInc = max(leftInc,rightInc);
        int maxDec = max(leftDec,rightDec);
        
        maxLen = max(maxLen,max(maxInc,maxDec));
        maxLen = max(maxLen,maxInc+maxDec-1);
        
        return {maxInc,maxDec};
    }
    int longestConsecutive(TreeNode* root) {
        getLCS(root);
        return maxLen;
    }
};