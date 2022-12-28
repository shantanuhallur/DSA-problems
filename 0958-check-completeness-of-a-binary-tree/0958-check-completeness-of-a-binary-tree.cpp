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
        bool treeEnd = false;
        queue<TreeNode*> que;
        que.push(root);
        //inserting nodes level by level
        while(que.size()!=0) {
            TreeNode* removeN = que.front(); que.pop();
            //if the remove node is null it means that tree has ended.
            if(!removeN) {
                treeEnd = true;
            }
            else{
                //check if tree has ended and if we have recieved an existant node return false.
                if(treeEnd) return false;
                que.push(removeN->left);
                que.push(removeN->right);
            }
        }
        return true;
    }
};