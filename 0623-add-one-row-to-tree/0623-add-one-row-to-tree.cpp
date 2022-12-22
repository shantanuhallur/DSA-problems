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
        if(depth == 1) {
            TreeNode* base = new TreeNode(val);
            base->left = root;
            return base;
        }
        
        int level = 1;
        
        queue<TreeNode*> que;
        
        que.push(root);
        
        while(level < depth-1) {
            int size = que.size();
            while(size-- >0) {
                TreeNode* rn = que.front(); que.pop();
                
                if(rn->left != nullptr) {
                    que.push(rn->left);
                }
                
                if(rn->right != nullptr) {
                    que.push(rn->right);
                }
            }
            level++;
        }
        
        while(que.size() != 0) {
            TreeNode* rn = que.front(); que.pop();
            
                TreeNode* temp1 = rn->left;
                TreeNode* temp2 = rn->right;
                rn->left = new TreeNode(val);
                rn->right = new TreeNode(val);
                rn->left->left = temp1;
                rn->right->right = temp2;
            }
            
        return root;
    }
};