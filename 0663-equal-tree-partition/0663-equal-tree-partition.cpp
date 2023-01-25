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
    vector<int> subtreeSum;
    int getTotalSum(TreeNode* node) {
        if(!node) return 0;
        int totalSum = node->val + getTotalSum(node->left) + getTotalSum(node->right);
        subtreeSum.push_back(totalSum);
        return totalSum;
    }
    bool checkEqualTree(TreeNode* root) {
        int totalSum = getTotalSum(root);
        if(totalSum%2!=0)return false;
        subtreeSum.pop_back();
        auto it = find (subtreeSum.begin(), subtreeSum.end(), totalSum/2);
        return it!=subtreeSum.end();
    }
};