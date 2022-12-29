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
        //BFS
        while(que.size()!=0) {
            int size = que.size();
            int increasing = -1;
            int decreasing = 1e8;
            while(size-->0) {
                TreeNode* removeN = que.front(); que.pop();
                
                //IF EVEN LEVEL
                if(level%2==0) {
                    if(removeN->val%2==0 || increasing >= removeN->val) return false;
                    increasing = removeN->val;
                }
                //ODD LEVEL
                else{
                    if(removeN->val %2==1 || decreasing <=removeN->val) return false;
                    decreasing = removeN->val;
                }
                
                //setup the next level in the tree
                if(removeN->left) que.push(removeN->left);
                
                if(removeN->right) que.push(removeN->right);
            }
            //increasing the level
            level++;
        }
        return true;
    }
};