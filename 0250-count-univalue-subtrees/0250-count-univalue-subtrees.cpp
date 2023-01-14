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
    int count=0;
    bool getCount(TreeNode* node,int checkVal) {
        if(node == NULL) return true;
        
        int checkValForMySubtree = node->val;
        bool leftAns= getCount(node->left,checkValForMySubtree);
        bool rightAns = getCount(node->right,checkValForMySubtree);
        
        if(leftAns && rightAns) count++;
        
        if(leftAns && rightAns && node->val == checkVal) return true;
        return false;
    }
    int countUnivalSubtrees(TreeNode* root) {
        if(!root) return 0;
        getCount(root,root->val);
        return count;
    }
};