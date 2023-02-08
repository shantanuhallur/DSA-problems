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
    int getPathSum(TreeNode* node,long prefSum,int target,unordered_map<long,int>& map) {
        if(!node) return 0;
        prefSum += node->val;
        int res = 0;
        if(map.find(prefSum-target) !=map.end()) {
            res += map[prefSum-target];
        }
        map[prefSum]++;
        res+= getPathSum(node->left,prefSum,target,map);
        res+= getPathSum(node->right,prefSum,target,map);
        map[prefSum]--;
        return res;
    }
    int pathSum(TreeNode* root, int targetSum) {
        unordered_map<long,int> map;
        map[0]++;
        return getPathSum(root,0,targetSum,map);
    }
};