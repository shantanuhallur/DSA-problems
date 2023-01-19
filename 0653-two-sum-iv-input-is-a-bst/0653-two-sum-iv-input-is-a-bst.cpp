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
    void addAllLeft(TreeNode* node,stack<TreeNode*>& st) {
        while(node != NULL) {
            st.push(node);
            node = node->left;
        }
    }
    void addAllRight(TreeNode* node,stack<TreeNode*>& st) {
        while(node != NULL) {
            st.push(node);
            node = node->right;
        }
    }
    bool findTarget(TreeNode* root, int k) {
        stack<TreeNode*> st1;
        stack<TreeNode*> st2;
        //setup both stacks
        addAllLeft(root,st1);
        addAllRight(root,st2);
        //check our conditions
        while(st1.top()->val < st2.top()->val) {
            int sum = st1.top()->val + st2.top()->val;
            if(sum == k) return true; // we found the pair
            else if(sum > k) {
                TreeNode* rn = st2.top(); st2.pop();
                addAllRight(rn->left,st2);
            }
            else if(sum < k) {
                TreeNode* rn = st1.top(); st1.pop();
                addAllLeft(rn->right,st1);
            }
        }
        return false;
    }
};