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
    int ans=0;
    bool findUnivalSUbtrees(TreeNode* node , int checkVal) {
        //Base Case
        if(!node) return true;
        int checkValForMyNodesSubtree = node->val;
        //left and right recursive call
        bool allLeftEqual = findUnivalSUbtrees(node->left,checkValForMyNodesSubtree);
        bool allRightEqual = findUnivalSUbtrees(node->right,checkValForMyNodesSubtree);
        //Univalue subtree if ->
        if(allLeftEqual && allRightEqual)ans++;
        //return condition
        if(allLeftEqual && allRightEqual && node->val == checkVal)return true;
        return false;
    }
    int countUnivalSubtrees(TreeNode* root) {
        if(!root) return 0;
        findUnivalSUbtrees(root,root->val);
        return ans;
    }
};