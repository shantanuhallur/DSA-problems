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
    void insertAllLeft(TreeNode* node, stack<TreeNode*>& st) {
        while(node) {
            st.push(node);
            node = node->left;
        }
    }
    int kthSmallest(TreeNode* root, int k) {
        stack<TreeNode*> st;
        insertAllLeft(root,st);
        
        while(k-->1) {
            TreeNode* removeN = st.top(); st.pop();
            insertAllLeft(removeN->right,st);
        }
        
        return st.top()->val;
    }
};