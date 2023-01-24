/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* dfs(TreeNode* node,TreeNode* target,unordered_map<TreeNode*,TreeNode*>& map) {
        if(!node) return NULL;
        if(node->val == target->val) return node;
        TreeNode* left = dfs(node->left,target,map);
        if(left) {
            map[node->left] = node;
            return left;
        }
        TreeNode* right = dfs(node->right,target,map);
        if(right) {
            map[node->right] = node;
            return right;
        }
        return NULL;
    }
    vector<int> distanceK(TreeNode* root, TreeNode* target, int k) {
        unordered_map<TreeNode*,TreeNode*> map;
        TreeNode* tar = dfs(root,target,map);
        set<int> vis;
        queue<TreeNode*> que;
        que.push(tar);
        cout<<tar->val;
        while(k-->0) {
            int size = que.size();
            while(size-->0) {
                TreeNode* rn = que.front(); que.pop();
                
                if(rn->left && vis.find(rn->left->val)==vis.end()) {
                    que.push(rn->left);
                    vis.insert(rn->left->val);
                }
                if(rn->right && vis.find(rn->right->val)==vis.end()) {
                    que.push(rn->right);
                    vis.insert(rn->right->val);
                }
                if(map.find(rn)!=map.end() && vis.find(map[rn]->val)==vis.end()) {
                    que.push(map[rn]);
                    vis.insert(rn->val);
                }
            }
        }
        vector<int> ans;
        while(que.size()>0) {
            ans.push_back(que.front()->val);
            que.pop();
        }
        return ans;
    }
};