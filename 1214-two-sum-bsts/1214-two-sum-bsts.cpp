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
    void traverse(TreeNode* node,int target,unordered_set<int>& set) {
        if(!node) return;
        
        set.insert(target-(node->val));
        traverse(node->left,target,set);
        traverse(node->right,target,set);
    }
    bool traverse1(TreeNode* node ,unordered_set<int>& set) {
        if(!node) return false;
        
        if(set.find(node->val) != set.end()) return true;
        bool left = traverse1(node->left,set);
        bool right = traverse1(node->right,set);
        
        return (left||right);
    }
    bool twoSumBSTs(TreeNode* root1, TreeNode* root2, int target) {
        unordered_set<int> set;
        traverse(root1,target,set);
        return traverse1(root2,set);
    }
};