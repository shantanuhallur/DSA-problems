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
        //Base condn
        if(root == nullptr) return 0;
        // Create Que
        queue<TreeNode*> que;
        que.push(root);
        int sum = 0;
        while(que.size()!=0) {
            int size = que.size();
            sum = 0;
            //maintain sum as 0 for each new level
            while(size-- > 0) {
                
                TreeNode* removeN = que.front(); que.pop();
                //if left and right child exists add in que.
                if(removeN->left != nullptr) que.push(removeN->left);
                
                if(removeN->right != nullptr) que.push(removeN->right);
                // sum of last level will get updated in latest sum.
                sum += removeN->val;
            }
        }
        
        return sum;
    }
};