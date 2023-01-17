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
    TreeNode* prev = NULL;
    int count = 1;
    int max = -1;
    void getNodes(TreeNode* node, vector<int>& ans) {
        if(!node) return;
        
        getNodes(node->left,ans);
        if(prev) {
            if(node->val == prev->val) {
                count++;
            }
            else {
                count = 1;
            }
        }
        
        if(count>max) {
            max = count;
            ans.clear();
            ans.push_back(node->val);
        }
        else if(count == max) {
            ans.push_back(node->val);
        }
        
        prev = node;
        getNodes(node->right,ans);
    }
    vector<int> findMode(TreeNode* root) {
        if(!root) return {};
        vector<int> ans;
        getNodes(root,ans);
        return ans;
    }
};