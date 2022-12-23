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
    int deepestLeavesSum(TreeNode* root) {
        if(root == nullptr) return 0;
        
        queue<TreeNode*> que;
        que.push(root);
        int sum = 0;
        
        while(que.size()!=0) {
            int size = que.size();
            sum = 0;
            while(size -->0) {
                TreeNode* removeN = que.front(); que.pop();
                
                if(removeN->left != nullptr) que.push(removeN->left);
                
                if(removeN->right != nullptr) que.push(removeN->right);
                
                sum += removeN->val;
                cout<<removeN->val;
            }
        }
        
        return sum;
    }
};