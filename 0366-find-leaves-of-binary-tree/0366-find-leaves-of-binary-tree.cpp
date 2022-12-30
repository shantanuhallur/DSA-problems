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
    vector<int> smallAns;
    TreeNode* remLeaves(TreeNode* node) {
        if(!node->left && !node->right){
            smallAns.push_back(node->val);
            return nullptr;  
        } 
        
        if(node->left) node->left = remLeaves(node->left);
        
        if(node->right) node->right = remLeaves(node->right);
        
        return node;
    }
    
    vector<vector<int>> findLeaves(TreeNode* root) {
        vector<vector<int>> ans;
        while(true) {
            smallAns.clear();
            if(root) {
                root = remLeaves(root);
            }
            else break;
            ans.push_back(smallAns);
        }
        return ans;
    }
};