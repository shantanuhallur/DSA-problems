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
    void inorder(TreeNode* node,vector<int>& sortedList) {
        if(!node) return;
        
        inorder(node->left,sortedList);
        sortedList.push_back(node->val);
        inorder(node->right,sortedList);
    }
    TreeNode* balance(vector<int>& sortedList,int st,int end) {
        if(st>end) return nullptr;
        
        int mid = (st+end)/2;
        
        TreeNode* root = new TreeNode(sortedList[mid]);
        root->left = balance(sortedList,st,mid-1);
        root->right = balance(sortedList,mid+1,end);
        
        return root;
    }
    TreeNode* balanceBST(TreeNode* root) {
        vector<int> sortedList;
        inorder(root,sortedList);
        
        root = balance(sortedList,0,sortedList.size()-1);
        return root;
    }
};