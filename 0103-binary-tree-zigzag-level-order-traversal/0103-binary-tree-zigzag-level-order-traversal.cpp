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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        if(!root) return {};
        vector<vector<int>> ans;
        int level = 1;
        queue<TreeNode*> que;
        que.push(root);
        
        while(que.size()!=0) {
            int size = que.size();
            vector<int> levelAns;
            while(size-->0) {
                TreeNode* removeN = que.front(); que.pop();
                
                if(removeN->left) {
                    que.push(removeN->left);
                }
                
                if(removeN->right) {
                    que.push(removeN->right);
                }
                
                if(level % 2 != 0) {
                    levelAns.push_back(removeN->val);
                }
                else levelAns.insert(levelAns.begin(),removeN->val);
            }
            ans.push_back(levelAns);
            level++;
        }
        return ans;
    }
};