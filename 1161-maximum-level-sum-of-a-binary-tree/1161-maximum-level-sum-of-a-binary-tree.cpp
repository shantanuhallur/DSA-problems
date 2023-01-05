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
    int maxLevelSum(TreeNode* root) {
        int maxSum=-1e6;
        int maxLevel=1;
        int level = 1;
        queue<TreeNode*> que;
        que.push(root);
        
        while(que.size()!=0) {
            int size = que.size();
            int sum = 0;
            while(size-->0) {
                TreeNode* removeN = que.front(); que.pop();
                
                sum += removeN->val;
                
                if(removeN->left) que.push(removeN->left);
                if(removeN->right) que.push(removeN->right);
            }
            if(sum>maxSum) {
                maxSum = sum;
                maxLevel = level;
            }
            
            level++;
        }
        return maxLevel;
    }
};