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
    int findMinInLeftSubtre(TreeNode* node) {
        while(node->left) node = node->left;
        //we get the minimum element in right subtree.
        return node->val;
    }
    TreeNode* deleteNode(TreeNode* root, int key) {
        //Base Case
        if(!root) return nullptr;
        //search in right
        if(root->val < key) {
            root->right = deleteNode(root->right,key);
        }
        //search in left
        else if(root->val > key) {
            root->left = deleteNode(root->left,key);
        }
        //else we have got the node to be deleted
        else {
            //if left child of node to be delete is null || right child is null or both are null
            if(root->left == nullptr || root->right == nullptr) {
                return root->left == nullptr ? root->right : root->left;
            }
            //both children left and right are present
            //get min element in right subtree
            int minEle = findMinInLeftSubtre(root->right);
            //subtitute our root's val with minEle
            root->val = minEle;
            //delete the node wil min element in right subtree
            root->right = deleteNode(root->right,minEle);
        }
        return root;
    }
};