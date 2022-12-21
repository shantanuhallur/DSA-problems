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
    vector<int> preorderTraversal(TreeNode* root) {
        if(root == nullptr) return {};
        vector<int> list;
        
        stack<TreeNode*> stack;
        stack.push(root);
        while(stack.size()!=0) {
            TreeNode* rn = stack.top(); stack.pop();
            
            if(rn->right != nullptr) {
                stack.push(rn->right);
            }
            
            if(rn->left != nullptr) {
                stack.push(rn->left);
            }
            
            list.push_back(rn->val);
        }
        
        return list;
    }
};