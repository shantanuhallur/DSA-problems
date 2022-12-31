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
        //LEVEL ORDER TRAVERSAL
        while(que.size()!=0) {
            int size = que.size();
            //setting up next level in que and processing this one.
            for(int i=0;i<size;i++) {
                TreeNode* removeN = que.front(); que.pop();
                
                //if left and right child exists add them
                if(removeN->left) que.push(removeN->left);
                
                if(removeN->right) que.push(removeN->right);
                
                //checking if current removeN is equal to U
                if(removeN->val == u->val && i != size-1) {
                    ans = que.front();
                }
            }
        }
        return ans;
    }
};