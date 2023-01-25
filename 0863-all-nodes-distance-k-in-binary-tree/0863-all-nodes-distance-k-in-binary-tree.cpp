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
    TreeNode* dfs(TreeNode* node,TreeNode* target,unordered_map<int,TreeNode*>& bm) {
        if(!node) return NULL;
        if(node->val == target->val) return node;
        TreeNode* left = dfs(node->left,target,bm);
        if(left) {
            bm[node->left->val] = node;
            return left;
        }
        TreeNode* right = dfs(node->right,target,bm);
        if(right) {
            bm[node->right->val] = node;
            return right;
        }
        return NULL;
    }
    vector<int> distanceK(TreeNode* root, TreeNode* target, int k) {
        //set , map , que
        set<int> vis;
        unordered_map<int,TreeNode*> bm;
        queue<TreeNode*> que;
        //get target
        TreeNode* tar = dfs(root,target,bm);
        cout<<tar->val;
        //BFS
        que.push(tar);
        while(k-->0) {
            int size = que.size();
            while(size-->0) {
                TreeNode* rn = que.front(); que.pop();
                //left and right bfs
                if(rn->left && vis.find(rn->left->val)==vis.end()) {
                    que.push(rn->left);
                    vis.insert(rn->left->val);
                }
                
                if(rn->right && vis.find(rn->right->val)==vis.end()) {
                    que.push(rn->right);
                    vis.insert(rn->right->val);
                }
                //EXPLORE PARENT
                if(bm.find(rn->val)!=bm.end()) {
                    que.push(bm[rn->val]);
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