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
    TreeNode* addOneRow(TreeNode* root, int val, int depth) {
        //Base case
        if(depth == 1) {
            TreeNode* base = new TreeNode(val);
            base->left = root;
            return base;
        }
        int level = 1;
        //Declare define a que
        queue<TreeNode*> que;
        que.push(root);
        
        while(level < depth-1){
            int size = que.size();
            while(size-- >0) {
                TreeNode* removeN = que.front(); que.pop();
                
                if(removeN ->left != nullptr) {
                    que.push(removeN ->left);
                }
                
                if(removeN ->right != nullptr) {
                    que.push(removeN ->right);
                }
            }
            level++;
        }
        
        //Add Nodes.
        while(que.size()!=0) {
            TreeNode* removeN = que.front(); que.pop();
            
            TreeNode* temp1 = removeN->left;
            TreeNode* temp2 = removeN->right;
            
            TreeNode* newLeftN = new TreeNode(val);
            TreeNode* newRightN = new TreeNode(val);
            
            removeN->left = newLeftN;
            removeN->right = newRightN;
            
            newLeftN->left = temp1;
            newRightN->right = temp2;
            
        }
        
        return root;
    }
};