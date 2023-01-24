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
    TreeNode* getTar(TreeNode* node,unordered_map<TreeNode*,TreeNode*>& map,int target) {
        if(!node) return NULL;
        if(node->val == target) return node;
        
        TreeNode* left = getTar(node->left,map,target);
        if(left) {
            map[node->left] = node;
            return left;
        }
        TreeNode* right = getTar(node->right,map,target);
        if(right) {
            map[node->right] = node;
            return right;
        }
        return NULL;
    }
    int findClosestLeaf(TreeNode* root, int k) {
        unordered_map<TreeNode*,TreeNode*> map;
        TreeNode* tar = getTar(root,map,k);
        set<int> vis;
        queue<TreeNode*> que;
        que.push(tar);
        while(que.size()!=0) {
            int size = que.size();
            while(size-->0) {
                TreeNode* rn = que.front(); que.pop();
                if(!rn->left && !rn->right) {
                    return rn->val;
                }
                if(rn->left && vis.find(rn->left->val) == vis.end()) {
                    que.push(rn->left);
                    vis.insert(rn->left->val);
                }
                
                if(rn->right && vis.find(rn->right->val)==vis.end()) {
                    que.push(rn->right);
                    vis.insert(rn->right->val);
                }
                
                if(map.find(rn) != map.end() && vis.find(map[rn]->val)==vis.end()) {
                    que.push(map[rn]);
                    vis.insert(rn->val);
                }
            }
        }
        return -1;
    }
};