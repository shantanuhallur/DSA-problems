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
    TreeNode* delNodes_01(TreeNode* node, vector<int>& to_delete,vector<TreeNode*>& ans) {
        if(!node) return nullptr; 
        //Recursive Calls
        node->left = delNodes_01(node->left,to_delete,ans);
        node->right = delNodes_01(node->right,to_delete,ans);
        
        //Deletion
        if(find(to_delete.begin(),to_delete.end(),node->val) != to_delete.end()) {
            if(node->left) {
                ans.push_back(node->left);
            }
            
            if(node->right) {
                ans.push_back(node->right);
            }
            return nullptr;
        }
        
        return node;
    }
    
    vector<TreeNode*> delNodes(TreeNode* root, vector<int>& to_delete) {
        vector<TreeNode*> ans;
        
        if(delNodes_01(root,to_delete,ans)) {
            ans.push_back(root);
        }
        return ans;
    }
};