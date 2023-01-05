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
        //Base Case if node is null we dont have any excessive or deficit coins
        if(!node) return 0;
        
        //get left & right node/subtree excessive deficit coins by recursive faith of call
        int leftExDef = distribute(node->left);
        int rightExDef = distribute(node->right);
        //count our total min moves
        moves += abs(leftExDef) + abs(rightExDef);
        //return our net ex def coins to parent
        return leftExDef + rightExDef + node->val - 1;
    }
    int distributeCoins(TreeNode* root) {
        distribute(root);
        return moves;
    }
};