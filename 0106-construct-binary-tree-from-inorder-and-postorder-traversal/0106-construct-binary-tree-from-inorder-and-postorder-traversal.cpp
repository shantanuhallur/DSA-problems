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
        TreeNode* buildTree(vector<int>& inorder,int isi,int iei,vector<int>& postorder,int psi, int pei) {
        if(psi>pei) return NULL;
        //construct root node;
        TreeNode* node = new TreeNode(postorder[pei]);
        //start finding this element from start of inorder
        int idx = isi; 
        //find in inorder idx element;
        while(inorder[idx] != postorder[pei])idx++;
        int tel = idx - isi; //total no of elements
        
        node->left = buildTree(inorder,isi,idx-1,postorder,psi,psi+tel-1);
        node->right = buildTree(inorder,idx+1,iei,postorder,psi+tel,pei-1);
        
        return node;
    }
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        return buildTree(inorder,0,inorder.size()-1,postorder,0,postorder.size()-1);
    }
};