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
    int findBottomLeftValue(TreeNode* root) {
        queue<TreeNode*> que;
        que.push(root);
        
        while(que.size()!=0) {
            //remove the node in front of que
            root = que.front(); que.pop();
            
            //FIRST add RIGHT child then LEFT child.
            if(root->right) que.push(root->right);
            
            if(root->left) que.push(root->left);
        }
        
        return root->val;
    }
};