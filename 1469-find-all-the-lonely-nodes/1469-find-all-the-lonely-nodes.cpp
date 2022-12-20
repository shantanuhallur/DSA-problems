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
    bool getLonelyNodes_01(TreeNode* node,vector<int>& ans) {
    //Base case
        if(node == nullptr) return false;
        
        //Left Recursive Call
        bool hasLeftChild = getLonelyNodes_01(node->left,ans);
        //Right Recursive Call
        bool hasRightChild = getLonelyNodes_01(node->right,ans);
        //if has left Child but not Right Child
        if(hasLeftChild && !hasRightChild) {
            ans.push_back(node->left->val);
        }
        //if has right Child but not left Child
        if(hasRightChild && !hasLeftChild) {
            ans.push_back(node->right->val);
        }
        
        return true;
    }
    
    vector<int> getLonelyNodes(TreeNode* root) {
        vector<int> ans;
        getLonelyNodes_01(root,ans);
        return ans;
    }
};