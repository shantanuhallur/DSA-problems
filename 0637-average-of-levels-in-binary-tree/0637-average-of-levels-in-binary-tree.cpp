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
    void averageOfLevels_01(TreeNode* node,vector<double>& ans) {
        queue<TreeNode*> que;
        que.push(node);
        
        while(que.size()!=0) {
            double sum = 0;
            double size = que.size();
            double originalSize = size;
            while(size-- != 0) {
                TreeNode* removeN = que.front(); que.pop();
                sum += removeN->val;
                
                if(removeN->left != nullptr) {
                    que.push(removeN->left);
                }
                
                if(removeN->right != nullptr){
                     que.push(removeN->right);
                }
            }
            ans.push_back(sum/originalSize);
        }
    }
    vector<double> averageOfLevels(TreeNode* root) {
        vector<double> ans;
        averageOfLevels_01(root,ans);
        return ans;
    }
};