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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        if(!root) return {};
        
        vector<vector<int>> ans;
        queue<TreeNode*> que;
        que.push(root);
        int level = 1;
        //Level Order Traversal
        while(que.size()!=0) {
            int size = que.size();
            vector<int> levelAns;
            // process every level
            while(size-->0) {
                TreeNode* removeN = que.front(); que.pop();
                //Set up the next level
                if(removeN->left) {
                    que.push(removeN->left);
                }
                
                if(removeN->right) {
                    que.push(removeN->right);
                }
                //UNIQUE PROCESS OF OUR LEVEL ANS
                if(level%2 ==0) {
                    //IF EVEN -->>
                    levelAns.insert(levelAns.begin(),removeN->val);
                }
                else {
                    levelAns.push_back(removeN->val);
                }
            }
            //INCREMENT OUR LEVEL
            level++;
            //SAVE OUR PREOCESSED LEVEL ANS
            ans.push_back(levelAns);
        }
        return ans;
    }
};