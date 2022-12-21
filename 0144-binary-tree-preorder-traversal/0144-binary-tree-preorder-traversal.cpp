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
        //if root is null return empty vector
        if(root == nullptr) return vector<int> {};
        vector<int> ans;
        stack<TreeNode*> st;
        //add our Root
        st.push(root);
        //Execute while loop
        while(st.size()!=0) {
            //get removed node from stack's top
            TreeNode* removeN = st.top(); st.pop();
            
            //push right
            if(removeN->right != nullptr) {
                st.push(removeN->right);
            }
            //push left
            if(removeN->left != nullptr) {
                st.push(removeN->left);
            }
            
            ans.push_back(removeN->val);
        }
        
        return ans;
    }
};