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
        //Base Case
        if(!node) return;
        //left and right recursive calls
        inorder(node->left,sortedList);
        //INORDER AREA ----->>>
        sortedList.push_back(node->val);
        //INORDER AREA ----->>>
        inorder(node->right,sortedList);
    }
    TreeNode* buildBST(vector<int>& sortedList,int st,int end) {
        //Base Case
        if(st>end) return nullptr;
        
        //calculate mid
        int mid = (st+end)/2;
        TreeNode* root = new TreeNode(sortedList[mid]);
        //attach recursively roots left and right subtree
        root->left = buildBST(sortedList,st,mid-1);
        root->right = buildBST(sortedList,mid+1,end);
        
        return root;
    }
    TreeNode* balanceBST(TreeNode* root) {
        vector<int> sortedList;
        inorder(root,sortedList);
        
        return buildBST(sortedList,0,sortedList.size()-1);
    }
};