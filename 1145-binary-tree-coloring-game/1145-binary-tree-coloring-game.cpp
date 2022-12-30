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
    int xLeftCount = 0;
    int xRightCount = 0;
    int countNodes(TreeNode* node, int x) {
        //Base Case 
        if(!node) return 0;
        
        //Left&right Recursive Call
        int leftNCount = countNodes(node->left,x);
        int rightNCount = countNodes(node->right,x);
        //Check if the current node is the one we want left and right subtrees Count
        if(node->val == x) {
            xLeftCount = leftNCount;
            xRightCount = rightNCount;
        }
        return leftNCount+rightNCount+1;
    }
    bool btreeGameWinningMove(TreeNode* root, int n, int x) {
        countNodes(root,x);
        int remainingN = n - (xLeftCount+xRightCount+1);
        if(xLeftCount>n/2 || xRightCount>n/2 || remainingN>n/2) return true;
        else return false;
    }
};