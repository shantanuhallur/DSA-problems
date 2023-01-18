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
    bool areEqual(TreeNode*  node1,TreeNode* node2) {
        if(node1==NULL && node2==NULL) return true; // both are null hence equal.
        if(node1 ==NULL || node2 ==NULL) return false; // only 1 node exists out of the 2.
        if(node1->val != node2->val) return false;// both nodes are present but dont have equal values
        
        //left and right recursive call
        bool lEqual = areEqual(node1->left,node2->left);
        bool rEqual = areEqual(node1->right,node2->right);
        
        return (lEqual && rEqual);
    }
    
    bool isSubtree(TreeNode* root, TreeNode* subRoot) {
        //Base Case
        if(!root) return false;
        
        if(root->val == subRoot->val) {
            if(areEqual(root,subRoot)) return true;
        }
        //left and right recursive calls
        bool lAns = isSubtree(root->left,subRoot);
        bool rAns = isSubtree(root->right,subRoot);
        
        return (lAns || rAns);
    }
};