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
    int ans = 1;
    
    void getLongestStreak(TreeNode* node,int parVal,int parStreak) {
        if(!node) return;
        //start my Streak
        int currStreak = 1;
        if(node->val == parVal+1) currStreak += parStreak;
        //maximize current ans
        ans = max(ans,currStreak);
        //left and right recursive call
        getLongestStreak(node->left,node->val,currStreak);
        getLongestStreak(node->right,node->val,currStreak);
    }
    int longestConsecutive(TreeNode* root) {
        getLongestStreak(root,root->val,0);
        return ans;
    }
};