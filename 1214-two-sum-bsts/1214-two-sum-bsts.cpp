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
    void traverse(TreeNode* node,unordered_set<int>& set,int target) {
        //Base Case
        if(!node) return;
        // Fill the set
        set.insert(target-node->val);
        //left and right recursive call
        traverse(node->left,set,target);
        traverse(node->right,set,target);
        
    }
    bool traverse1(TreeNode* node,unordered_set<int>& set) {
        //Base Case
        if(!node) return false;
        //check if set contains Y -> (target-x)
        if(set.find(node->val) != set.end()) return true;
        //else run left and righ recursive calls
        bool leftFound = traverse1(node->left,set);
        bool rightFound = traverse1(node->right,set);
        
        return leftFound || rightFound;
    }
    bool twoSumBSTs(TreeNode* root1, TreeNode* root2, int target) {
        unordered_set<int> set;
        traverse(root1,set,target);
        return traverse1(root2,set);
    }
};