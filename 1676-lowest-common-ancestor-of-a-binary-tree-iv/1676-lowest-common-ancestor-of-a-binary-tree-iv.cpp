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
    TreeNode* LCA = nullptr;
    int getLCA(TreeNode* node,unordered_set<int>& set) {
        if(!node) return 0;
        
        int leftCount = getLCA(node->left,set);
        int rightCount = getLCA(node->right,set);
        int totalCount = leftCount+rightCount;
        if(set.find(node->val)!= set.end()) totalCount++;
        if(!LCA && totalCount ==set.size()) LCA = node;
        
        return totalCount;
    }
    TreeNode* lowestCommonAncestor(TreeNode* root, vector<TreeNode*> &nodes) {
     unordered_set<int> set;
        for(TreeNode* node : nodes) {
            set.insert(node->val);
        }
        getLCA(root,set);
        return LCA;
    }
};