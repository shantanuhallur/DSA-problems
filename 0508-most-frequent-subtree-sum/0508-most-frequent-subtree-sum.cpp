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
    int  getfreq(TreeNode* node,unordered_map<int,int>& map) {
        if(!node) return 0;
        
        int leftS = getfreq(node->left,map);
        int rightS = getfreq(node->right,map);
        
        int totalS = leftS + rightS + node->val;
        
        map[totalS]++;
        
        return totalS;
    }
    vector<int> findFrequentTreeSum(TreeNode* root) {
        unordered_map<int,int> map;
        vector<int> ans;
        getfreq(root,map);
        int maxFreq = -1;
        for(auto it :map) {
            if(it.second > maxFreq) maxFreq = it.second;
        }
        for(auto it:map) {
            if(it.second == maxFreq) ans.push_back(it.first);
        }
        return ans;
    }
};