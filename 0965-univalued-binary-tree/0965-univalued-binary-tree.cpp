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
    bool isUnivalTree_01(TreeNode* root, int val) {
        //Base Case
        if(root == nullptr) return true;
        //Left Recursive Call
        bool hasLeftSameVal = isUnivalTree_01(root->left,val);
        //Right Recursive Call
        bool hasRightSameVal = isUnivalTree_01(root->right,val);
        
        if(hasLeftSameVal && hasRightSameVal && root->val == val) return true;
        else return false;
    }
    
    bool isUnivalTree(TreeNode* root) {
        //Base Case
        if(root == nullptr) return true;
        int val = root->val;
        return isUnivalTree_01(root,val);
    }
};