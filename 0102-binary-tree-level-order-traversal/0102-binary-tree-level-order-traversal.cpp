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
    vector<vector<int>> levelOrder(TreeNode* root) {
        if(!root) return {};
         vector<vector<int>> ans;
        ///Declaration of que
        queue<TreeNode*> que;
        que.push(root);
        
        //WHILE LOOPS
        while(que.size()!=0) {
            int size = que.size();
            vector<int> levelAns;
            // Processing for each different level
            while(size-->0) {
                TreeNode* removeN = que.front(); que.pop();
                //setting up the next level in the que
                if(removeN->left) {
                    que.push(removeN->left);
                }
                
                if(removeN->right) {
                    que.push(removeN->right);
                }
                
                levelAns.push_back(removeN->val);
            }
            ans.push_back(levelAns);
        }
        return ans;
    }
};