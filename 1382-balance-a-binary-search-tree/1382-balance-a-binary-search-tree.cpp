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
    vector<int> sortedList;
    void inorder(TreeNode* node) {
        if(!node)return;
        
        inorder(node->left);
        sortedList.push_back(node->val);
        inorder(node->right);
    }
    
    TreeNode* balance(int st,int end) {
        if(st>end) return nullptr;
        
        int mid = (st+end)/2;
        TreeNode* root = new TreeNode(sortedList[mid]);
        
        root->left = balance(st,mid-1);
        root->right = balance(mid+1,end);
        
        return root;
    }
    
    TreeNode* balanceBST(TreeNode* root) {
       if(!root) return nullptr;
        inorder(root); 
        root = balance(0,sortedList.size()-1);
        return root;
    }
};