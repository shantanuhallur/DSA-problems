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
    vector<int> leaves;
    TreeNode* removeLeaves(TreeNode* node) {
        //Base Case  for leaves.
        if(!node->left && !node->right){
            leaves.push_back(node->val);
            return nullptr;
        }
        
        //Left & right recursive call
        if(node->left) node->left = removeLeaves(node->left);
        if(node->right) node->right = removeLeaves(node->right);
        
        return node;
    }
    vector<vector<int>> findLeaves(TreeNode* root) {
        vector<vector<int>> ans;
        
        while(true) {
            leaves.clear();
            //if Tree exists or root still exists
            if(root) {
                root = removeLeaves(root);
            }
            //else tree is now null
            else break;
            ans.push_back(leaves);
        }
        return ans;
    }
};