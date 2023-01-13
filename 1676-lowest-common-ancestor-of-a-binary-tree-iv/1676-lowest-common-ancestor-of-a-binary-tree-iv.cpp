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
    TreeNode* LCA = NULL;
    int getLCA(TreeNode* node,unordered_set<int>& set) {
        //Base Case
        if(!node) return 0;
        //left and right recursive call
        int leftFound = getLCA(node->left,set);
        int rightFound = getLCA(node->right,set);
        //calculate totalFOund
        int totalFound = leftFound+rightFound;
        //check if current node is to be searched for
        if(set.find(node->val) != set.end()) totalFound++;
        //check of current node is LCA
        if(LCA == NULL && totalFound == set.size()) LCA = node;
        //return totalfound to parent
        return totalFound;
    }
    TreeNode* lowestCommonAncestor(TreeNode* root, vector<TreeNode*> &nodes) {
        unordered_set<int> set;
        for(TreeNode* node : nodes) set.insert(node->val);
        getLCA(root,set);
        return LCA;
    }
};