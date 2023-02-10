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
        //setup que for BFS
        queue<TreeNode*> que;
        que.push(root);
        
        //start bfs
        while(que.size()!=0) {
            int size = que.size();
            //Inner loop for every level
            while(size-->0) {
                TreeNode* removeN = que.front(); que.pop();
                
                if(removeN->left) que.push(removeN->left);
                
                if(removeN->right) que.push(removeN->right);
                
                
                //last node save in ans;
                if(size==0) ans.push_back(removeN->val);
            }
        }
        return ans;
    }
};