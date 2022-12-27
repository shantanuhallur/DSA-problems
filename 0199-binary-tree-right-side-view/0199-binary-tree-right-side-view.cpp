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
    vector<int> rightSideView(TreeNode* root) {
        if(root == nullptr) return {};
        vector<int> ans;
        
        queue<TreeNode*> que;
        que.push(root);
        
        while(que.size()!=0) {
            int size = que.size();
            while(size-->0) {
                TreeNode* rn = que.front(); que.pop();
                
                if(rn->left) que.push(rn->left);
                
                if(rn->right) que.push(rn->right);
                
                if(size==0) ans.push_back(rn->val);
            }
        }
        return ans;
    }
};