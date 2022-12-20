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
    void getleafS(TreeNode* node,vector<int>& ans) {
        if(node == nullptr) return;
        if(node->left == nullptr && node->right == nullptr){
            ans.push_back(node->val);
        }
        
        getleafS(node->left,ans);
        getleafS(node->right,ans);
        
    }
    
    bool leafSimilar(TreeNode* root1, TreeNode* root2) {
        vector<int> ans1;
        vector<int> ans2;
        
        getleafS(root1,ans1);
        getleafS(root2,ans2);
        
        int i = ans1.size();
        int j = ans2.size();
        
        if(i!=j){
            return false;
        }
        
        while(--i >=0) {
            if(ans1[i] != ans2[i]) return false;
        }
        
        return true;
    }
};