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
       void pathSum(TreeNode* root, int targetSum,vector<vector<int>> & ans,vector<int>&curr) {
        if(root == NULL) return;
        
        if(root->left == NULL && root->right == NULL) {
            if( targetSum-root->val==0){
              vector<int> base = curr;
                base.push_back(root->val);
                ans.push_back(base);   
            }
            return;
        }
        curr.push_back(root->val); //backtracking in curr
        
        pathSum(root->left,targetSum-root->val,ans,curr);
        pathSum(root->right,targetSum-root->val,ans,curr);
        
        curr.pop_back(); //backtracking in curr
    }
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<vector<int>> ans;
        vector<int> curr;
        pathSum(root,targetSum,ans,curr);
        return ans;
    }
};