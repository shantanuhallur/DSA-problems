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
    TreeNode* delNodes_01(TreeNode* node,vector<TreeNode*>& ans, set<int> mySet) {
        if(node == nullptr) return nullptr;
        
        node->left = delNodes_01(node->left,ans,mySet);
        node->right = delNodes_01(node->right,ans,mySet);
        
        if(mySet.find(node->val) != mySet.end()){
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
        set<int> mySet;
        for(int ele : to_delete) {
            mySet.insert(ele);
        }
        
        vector<TreeNode*> ans;
        //if we dont have root value to delete add this value to our ans;
        auto pos = mySet.find(root->val);
        if(pos == mySet.end()) ans.push_back(root); 
        delNodes_01(root,ans,mySet);
        return ans;
    }
};