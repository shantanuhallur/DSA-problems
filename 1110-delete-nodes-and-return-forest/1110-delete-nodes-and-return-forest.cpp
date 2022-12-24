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
    TreeNode* delNodes_01(TreeNode* node,vector<TreeNode*>& ans, vector<int>& to_delete) {
        if(node == nullptr) return nullptr;
        
        node->left = delNodes_01(node->left,ans,to_delete);
        node->right = delNodes_01(node->right,ans,to_delete);
        
        if(find(to_delete.begin(),to_delete.end(),node->val) != to_delete.end()){
            if(node->left != nullptr){
                ans.push_back(node->left);
            } 
            
            if(node->right != nullptr){
                ans.push_back(node->right);
            }
            
            return nullptr;
        }
        
        return node;
    }
    
    vector<TreeNode*> delNodes(TreeNode* root, vector<int>& to_delete) {
        
        vector<TreeNode*> ans;
        //if we dont have root value to delete add this value to our ans;
        // auto pos = mySet.find(root->val);
        // if(pos == mySet.end()) ans.push_back(root); 
        
        if(delNodes_01(root,ans,to_delete)) ans.push_back(root);
        return ans;
    }
};