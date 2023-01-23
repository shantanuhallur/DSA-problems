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
    TreeNode* dfs(TreeNode* node,int target,unordered_map<int,TreeNode*>& bm) {
        if(!node) return NULL;
        if(target==node->val)return node;
        
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
    int findClosestLeaf(TreeNode* root, int k) {
        unordered_map<int,TreeNode*> bm;
        queue<TreeNode*> que;
        set<int> s;
        TreeNode* target = dfs(root,k,bm);
        // cout<<target->val;
        que.push(target);
        while(que.size()!=0) {
            int size = que.size();
            while(size-->0) {
                TreeNode* rn = que.front(); que.pop();
                if(!rn->left && !rn->right) return rn->val;
                
                if(rn->left && s.find(rn->left->val)==s.end()) {
                    que.push(rn->left);
                    s.insert(rn->left->val);
                }
                if(rn->right && s.find(rn->right->val) == s.end()) {
                    que.push(rn->right);
                    s.insert(rn->right->val);
                }
                 
                if(bm.find(rn->val)!=bm.end() && s.find(bm[rn->val]->val)==s.end()) {
                    cout<<bm[rn->val]->val;
                    que.push(bm[rn->val]);
                    s.insert(rn->val);
                }
            }
        }
        return -1;
    }
};