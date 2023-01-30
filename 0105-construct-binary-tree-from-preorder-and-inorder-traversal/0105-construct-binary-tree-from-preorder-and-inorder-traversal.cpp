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
    
        TreeNode* buildTree(vector<int>& preorder,int psi,int pei, vector<int>& inorder,int isi,int iei) {
        if(psi>pei){ //for 1 node (0,0) indexes will get passed as psi+1 , psi + isi = (1,0)
            return NULL;
        }
        
        TreeNode* node = new TreeNode(preorder[psi]); //root node is starting node of preorder.
        int idx = isi;
        //find this root node in inorder array.
        while(preorder[psi] != inorder[idx]) idx++;
        //find how many elements are behind this found root in inorder.
        int tel = idx - isi; //total no of elements = idx - inorder starting index.
        
        node->left = buildTree(preorder,psi+1,psi+tel,inorder,isi,idx-1);
        node->right = buildTree(preorder,psi+tel+1,pei,inorder,idx+1,iei);
        
        return node;
    }
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        return buildTree(preorder,0,preorder.size()-1,inorder,0,inorder.size()-1);
    }
};