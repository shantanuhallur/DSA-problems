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
    void insertAllLeft(TreeNode* node , stack<TreeNode*>& st) {
        while(node) {
            st.push(node);
            //shift node to its left
            node = node->left;
        }
    }
    int kthSmallest(TreeNode* root, int k) {
        stack<TreeNode*> st;
        insertAllLeft(root,st);
        //run our while loop to get nodes in sorted order.
        while(k-->1) {
            TreeNode* removeN = st.top(); st.pop();
            //insert all left nodes of right node of this removeN
            insertAllLeft(removeN->right,st);
        }
        
        return st.top()->val;
    }
};