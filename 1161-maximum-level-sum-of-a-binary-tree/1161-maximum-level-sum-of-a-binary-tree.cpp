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
        // define initial variables
        int AnsLevel = 1;
        int maxSum = -1e6;
        int level = 1;
        queue<TreeNode*> que;
        que.push(root);
        //Level order traversal
        while(que.size()!=0) {
            int levelSum = 0;
            int size = que.size();
            while(size-->0) {
                TreeNode* removeN = que.front(); que.pop();
                
                levelSum += removeN->val;
                //setup next level of que
                if(removeN->left) que.push(removeN->left);
                if(removeN->right) que.push(removeN->right);
            }
            //update maxSUm if required
            if(maxSum<levelSum) {
                maxSum = levelSum;
                AnsLevel = level;
            }
            //go to next level;
            level++;
        }
        return AnsLevel;
    }
};