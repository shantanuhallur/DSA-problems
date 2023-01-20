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
    vector<TreeNode*> generateTree(int st,int end) {
        if(st>end) {
            vector<TreeNode*> base;
            base.push_back(nullptr);
            return base;
        }
        vector<TreeNode*> ans;
        for(int i=st;i<=end;i++) {
            vector<TreeNode*> left = generateTree(st,i-1);
            vector<TreeNode*> right = generateTree(i+1,end);
            for(TreeNode* l : left) {
                for(TreeNode* r : right) {
                    TreeNode* root = new TreeNode(i);
                    root->left = l;
                    root->right = r;
                    ans.push_back(root);
                }
            }
        }
        return ans;
    }
    vector<TreeNode*> generateTrees(int n) {
        return generateTree(1,n);
    }
};