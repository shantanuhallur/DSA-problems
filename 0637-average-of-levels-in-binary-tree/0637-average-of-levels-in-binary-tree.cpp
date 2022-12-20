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
    vector<double> averageOfLevels(TreeNode* root) {
        vector<double> ans;
        queue<TreeNode*> que;
        que.push(root);
        int level = 0;
        
        while(que.size()!=0) {
            double size = que.size();
            double orSize = size;
            double levelAns = 0;
            while(size-->0) {
                TreeNode* rn = que.front(); que.pop();
                levelAns += rn->val;
                
                if(rn->left != nullptr) {
                    que.push(rn->left);
                }
                
                if(rn->right != nullptr) {
                    que.push(rn->right);
                }
            }
            ans.push_back(levelAns/orSize);
            level++;
        }
        return ans;
    }
};