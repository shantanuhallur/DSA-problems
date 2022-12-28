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
    bool isCompleteTree(TreeNode* root) {
        bool end = false;
        queue<TreeNode*> que;
        que.push(root);
        
        while(que.size()!=0) {
            TreeNode* removeN = que.front(); que.pop();
            
            if(!removeN) {
                end = true;
            }
            else{
                if(end) return false;
                que.push(removeN->left);
                que.push(removeN->right);
            }
        }
        return true;
    }
};