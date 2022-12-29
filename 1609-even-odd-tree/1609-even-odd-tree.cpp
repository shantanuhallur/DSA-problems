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
    bool isEvenOddTree(TreeNode* root) {
        queue<TreeNode*> que;
        que.push(root);
        int level = 0;
        while(que.size()!=0) {
            int size = que.size();
            int min = -1;
            int max = 1e8;
            while(size-->0) {
                TreeNode* removeN = que.front(); que.pop();
                //even index
                if(level%2==0) {
                    if(removeN->val % 2 == 0 || removeN->val <= min) return false;
                    min = removeN->val;
                }
                else{
                    if(removeN->val % 2 != 0 || removeN->val >= max) return false;
                    max = removeN->val;
                }
                
                if(removeN->left) que.push(removeN->left);
                
                if(removeN->right) que.push(removeN->right);
            }
            level++;
        }
        return true;
    }
};