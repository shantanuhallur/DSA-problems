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
    TreeNode* correctBinaryTree(TreeNode* root) {
        //create a set and que for seen node and BFS
        unordered_set<int> set;
        queue<TreeNode*> que;
        que.push(root);
        //LEVEL ORDER TRAVERSAL
        while(que.size()!=0) {
            int size = que.size();
            while(size-->0) {
                TreeNode* removeN = que.front(); que.pop();
                 //if my child exists then search for its right pointing node
                 //start preocessing childs from right to left
                if(removeN->right) {
                    if(removeN->right->right && set.find(removeN->right->right->val) != set.end()) {
                        removeN->right = NULL;
                    }
                    else {
                        set.insert(removeN->right->val);
                        que.push(removeN->right);
                    }
                }
                
                 if(removeN->left) {
                    if(removeN->left->right && set.find(removeN->left->right->val) != set.end()) {
                        removeN->left = NULL;
                    }
                     else {
                        set.insert(removeN->left->val);
                         que.push(removeN->left);
                     }
                }
            }
        }
        return root;
    }
};