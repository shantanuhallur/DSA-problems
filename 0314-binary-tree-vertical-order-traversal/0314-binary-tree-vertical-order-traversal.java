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
    vector<vector<int>> verticalOrder(TreeNode* root) {
        vector<vector<int>> ans;
        if(!root) return ans;
        map<int,vector<int>> mp;
        queue<TreeNode*> que;
        queue<int> col;
        que.push(root); col.push(0);
        int minEle = 0, maxEle = 0;
        while(que.size()!=0) {
            TreeNode* rn = que.front(); que.pop();
            int rc = col.front(); col.pop();
            
            if(rn->left) {
                que.push(rn->left);
                col.push(rc-1);
                minEle = min(minEle,rc-1);
            }
            
            if(rn->right) {
                que.push(rn->right);
                col.push(rc+1);
                maxEle = max(maxEle,rc+1);
            }
            
            mp[rc].push_back(rn->val);
        }
        for(int i=minEle ; i<=maxEle ;i++) {
            ans.push_back(mp[i]);
        }
        return ans;
    }
};