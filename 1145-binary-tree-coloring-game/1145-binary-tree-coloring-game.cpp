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
    int leftNCount = 0;
    int rightNCount = 0;
    int lrSum = 0;
    int countNodes(TreeNode* node, int x) {
        //Base Case
        if(!node) return 0;
        
        //left recursive call
        int leftN = countNodes(node->left,x);
        int rightN = countNodes(node->right,x);
        
        if(node->val == x) {
            leftNCount = leftN;
            rightNCount = rightN;
            lrSum = leftN+rightN+1;
        }
        
        return leftN+rightN+1;
    }
    bool btreeGameWinningMove(TreeNode* root, int n, int x) {
        countNodes(root,x);
        if(leftNCount> n/2 || rightNCount> n/2 || n-lrSum > n/2) return true;
        else return false;
    }
};