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
    void insertAllLeft(TreeNode* node,stack<TreeNode*>& st) {
        while(node){
            st.push(node);
            node = node->left;
        }
    }
    
    void insertAllRight(TreeNode* node,stack<TreeNode*>& st) {
        while(node){
            st.push(node);
            node = node->right;
        }
    }
    
    bool findTarget(TreeNode* root, int k) {
        stack<TreeNode*> st1,st2;
        insertAllLeft(root,st1);
        insertAllRight(root,st2);
        
        while(st1.top()->val < st2.top()->val) {
            int lo = st1.top()->val;
            int hi = st2.top()->val;
            // int sum =
            if(k> lo+hi) {
                TreeNode* node = st1.top(); st1.pop();
                insertAllLeft(node->right,st1);
            }
            else if(k<lo+hi) {
                TreeNode* node = st2.top();  st2.pop();
                insertAllRight(node->left,st2);
            }
            else if(k == lo+hi) return true;
        }
        return false;
    }
};