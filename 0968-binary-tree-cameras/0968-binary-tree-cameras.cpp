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
    int camera = 0;
    int capture(TreeNode* node) {
        if(!node) return 0;
        
        int left = capture(node->left);
        int right = capture(node->right);
        
        if( left == -1 || right == -1) {
            camera ++;
            return 1;
        }
        
        if(left == 1 || right == 1)return 0;
        
        return -1;
    }
    int minCameraCover(TreeNode* root) {
        int check = capture(root);
        if(check == -1) camera++;
        return camera;
    }
};