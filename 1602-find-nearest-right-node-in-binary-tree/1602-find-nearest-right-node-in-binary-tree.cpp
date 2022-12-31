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
    TreeNode* findNearestRightNode(TreeNode* root, TreeNode* u) {
        queue<TreeNode*> que;
        que.push(root);
        TreeNode* ans = nullptr;
        while(que.size()!=0) {
            int size = que.size();
            for(int i=0;i<size;i++) {
                TreeNode* removeN = que.front(); que.pop();
                
                if(removeN->left) que.push(removeN->left);
                if(removeN->right) que.push(removeN->right);
                
                if(removeN->val == u->val && i != size-1) ans = que.front();
            }
        }
        return ans;
    }
};