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
    int cameras = 0;
    int getInfo(TreeNode* node) {
        if(!node) return 0;
        
        int leftInfo = getInfo(node->left);
        int rightInfo = getInfo(node->right);
        
        if(leftInfo == -1 || rightInfo == -1) {
            cameras++;
            return 1;
        }
        
        if(leftInfo == 1 || rightInfo == 1) return 0;
        
        return -1;
    }
    int minCameraCover(TreeNode* root) {
        int rootInfo = getInfo(root);
        if(rootInfo == -1) cameras++;
        return cameras;
    }
};