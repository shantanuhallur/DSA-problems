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
    vector<int> largestValues(TreeNode* root) {
        if(!root) return {};
        vector<int> ans;
        queue<TreeNode*> que;
        que.push(root);
        //LVL ORFER TRAVERSAL
        while(que.size()!=0) {
            int size = que.size();
            int largest = que.front()->val;
            while(size-->0) {
                TreeNode* removeN = que.front(); que.pop();
                
                if(removeN->left) que.push(removeN->left);
                
                if(removeN->right) que.push(removeN->right);
                //UPDATE LARGEST
                if(removeN->val >= largest) largest = removeN->val;
            }
            ans.push_back(largest);
        }
        return ans;
    }
};