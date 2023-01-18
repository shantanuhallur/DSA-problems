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
    int parent = -1;
    int getDepth(TreeNode* node,int depth,int target) {
        //Base Case
        if(node->val == target) return depth;
        //left and right DFS/Recursive calls
        if(node->left) {
            //check if curr node is a parent to my target node
            if(node->left->val == target) parent = node->val;
            //get height form child
            int lAns = getDepth(node->left,depth+1,target);
            if(lAns != 0) return lAns;
        }
        if(node->right) {
            //check if curr node is a parent to my target node
            if(node->right->val == target) parent = node->val;
            //get height form child
            int rAns = getDepth(node->right,depth+1,target);
            if(rAns != 0) return rAns;
        }
        return 0;
    }
    
    bool isCousins(TreeNode* root, int x, int y) {
        //get dep & par for X
        int dep1 = getDepth(root,0,x);
        int par1 = parent;
        parent = -1;
        //get dep & par for Y
        int dep2 = getDepth(root,0,y);
        int par2 = parent;
        //Check if both are Cousin or not.
        return dep1==dep2 && par1 != par2 ? true : false;
    }
};