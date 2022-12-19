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
    bool getLonelyNodes_01(TreeNode* node, vector<int>& ans) {
        if(node == nullptr) return false;
        
        bool leftChild = getLonelyNodes_01(node->left,ans);
        bool rightChild = getLonelyNodes_01(node->right,ans);
        
        if(leftChild && !rightChild) {
            ans.push_back(node->left->val);
        }
        
        if(rightChild && !leftChild) {
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