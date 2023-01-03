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
    void dfs(Node* node,vector<int>& freq){
        //Base Case
        if(!node) return;
        //check if node val is not + if not then increment the corresponding mapping index int freq.
        if(node->val != '+') freq[node->val-'a']++;
        //Frequency calculated by traversing the whole tree by left and right recursive call
        dfs(node->left,freq);
        dfs(node->right,freq);
    }
    bool checkEquivalence(Node* root1, Node* root2) {
        //get freq filled
        vector<int> freq(26,0);
        dfs(root1,freq);
        dfs(root2,freq);
        //check of any freq is odd if yes return false else return true
        for(int i=0;i<26;i++) {
            if(freq[i]%2 != 0) return false;
        }
        return true;
    }
};