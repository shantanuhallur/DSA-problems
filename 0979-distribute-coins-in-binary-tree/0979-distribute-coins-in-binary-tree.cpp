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
    int moves = 0;
    int distribute(TreeNode* node) {
        //Base Case
        if(!node) return 0;
        //Left and right recursive call of Faith to get excessive or deficit coins to trransact.
        int leftExDef = distribute(node->left);
        int rightExDef = distribute(node->right);
        
        //number of excessive and deficit move of coins we want to pass or recieve
        moves+= abs(leftExDef) + abs(rightExDef);
        //total number of excessive or deficit coins remained after all the transactions from left and right
        return leftExDef+rightExDef+node->val-1;
    }
    int distributeCoins(TreeNode* root) {
        distribute(root);
        return moves;
    }
};