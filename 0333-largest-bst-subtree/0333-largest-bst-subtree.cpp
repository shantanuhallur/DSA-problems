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
    vector<int> largestBST(TreeNode* node) {
        if(!node) return{(int)1e6,(int)-1e6,0};
        vector<int> l = largestBST(node->left);
        vector<int> r = largestBST(node->right);
        if(node->val > l[1] && node->val < r[0]) {
            return {min(l[0],node->val),max(node->val , r[1]),l[2]+r[2]+1};
        }
        else return {(int)-1e6,(int)1e6,max(l[2],r[2])};
    }
    int largestBSTSubtree(TreeNode* root) {
        vector<int> ret = largestBST(root);
        return ret[2];
    }
};