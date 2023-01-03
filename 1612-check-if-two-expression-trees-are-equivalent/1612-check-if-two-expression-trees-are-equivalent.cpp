/**
 * Definition for a binary tree node.
 * struct Node {
 *     char val;
 *     Node *left;
 *     Node *right;
 *     Node() : val(' '), left(nullptr), right(nullptr) {}
 *     Node(char x) : val(x), left(nullptr), right(nullptr) {}
 *     Node(char x, Node *left, Node *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    void dfs(Node* node,vector<int>& arr) {
        if(!node) return;
        
        if(node->val != '+') arr[node->val-'a']++;
        
        dfs(node->left,arr);
        dfs(node->right,arr);
    }
    bool checkEquivalence(Node* root1, Node* root2) {
        vector<int> arr(26,0);
        dfs(root1,arr);
        dfs(root2,arr);
        
        for(int i=0;i<26;i++){
            if(arr[i]%2 !=0)return false;
        }
        return true;
    }
};