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
    void fillGraph(TreeNode* node,vector<vector<int>>& graph) {
        if(!node) return;
        
        if(node->left) {
             graph[node->val].push_back(node->left->val);
            graph[node->left->val].push_back(node->val);
        }
        if(node->right) {
            graph[node->val].push_back(node->right->val);
            graph[node->right->val].push_back(node->val);
        }
        
        fillGraph(node->left,graph);
        fillGraph(node->right,graph);
    }
    
    int bfs(vector<vector<int>>& graph,int start) {
        vector<bool> vis(100001);
        int ans = 0;
        queue<int> que ; que.push(start);
        while(que.size()!=0) {
            int size = que.size();
            while(size-->0) {
                int removeN = que.front(); que.pop();
                vis[removeN] = 1;
                for(int i=0;i<graph[removeN].size();i++) {
                    if(!vis[graph[removeN][i]]) {
                        que.push(graph[removeN][i]);
                    }
                }        
            }
                ans++;
        }
        return ans;
    }
    int amountOfTime(TreeNode* root, int start) {
        vector<vector<int>> graph(100001);
        fillGraph(root,graph);
        
        return bfs(graph,start)-1;
    }
};