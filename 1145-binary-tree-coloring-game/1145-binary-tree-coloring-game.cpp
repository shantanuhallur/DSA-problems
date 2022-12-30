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
    int leftCount=0;
    int rightCount=0;
    int lrCount=0;
    int countNodes(TreeNode* node,int x) {
        if(!node) return 0;    
        
        int leftN = countNodes(node->left,x);
        
        int rightN = countNodes(node->right,x);
        
        if(node->val == x) {
            leftCount = leftN;
            rightCount = rightN;
            
            lrCount = leftN+rightN+1;
        }
        
        return leftN+rightN+1;
    }
    
    bool btreeGameWinningMove(TreeNode* root, int n, int x) {
        countNodes(root,x);
        if(leftCount>n/2 || rightCount>n/2 || n-lrCount>n/2) return true;
        else return false;
    }
};