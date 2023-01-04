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
    TreeNode* getLCA(TreeNode* node,int p,int q) {
        //base case
        if(node==nullptr) return nullptr;
        if(node->val == p || node->val==q) return node;
        ///left and right recursive calls
        TreeNode* leftFound = getLCA(node->left,p,q);
        TreeNode* rightFound = getLCA(node->right,p,q);
        
        if(leftFound && rightFound) return node; // IM THE LCA
        
        return leftFound != nullptr? leftFound : rightFound;
    }
    int getDist(TreeNode* node,int val,int dist) {
        //Base case
        if(node == nullptr) return 0;
        //return the distance till now if node is found
        if(node->val == val) return dist;
        
        int leftDist =  getDist(node->left,val,dist+1);
        if(leftDist>0) return leftDist;
        int rightDist = getDist(node->right,val,dist+1);
        if(rightDist>0) return rightDist;
        
        return leftDist+rightDist;
    }
    int findDistance(TreeNode* root, int p, int q) {
        //get LCA
        TreeNode* LCA = getLCA(root,p,q);
        //get distance of p and q from LCA
        int distP = getDist(LCA,p,0);
        int distQ = getDist(LCA,q,0);
        //return the sumation of these 2 distances.
        return distP+distQ;     
    }
};