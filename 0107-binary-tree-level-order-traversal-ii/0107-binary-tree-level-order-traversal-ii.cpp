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
        void levelOrder_M3(TreeNode* root, stack<vector<int>>& st) {
        queue<TreeNode*> que;
        que.push(root);

        int level = 0;
        while (que.size() != 0) {
            //System.out.println("Level :" + level + " : ");
            vector<int> smallAns;
            int size = que.size();
            while (size-- > 0) {
                TreeNode* rn = que.front(); que.pop(); // remove Node
                //System.out.print(rn.val + " ");
                smallAns.push_back(rn->val);

                if (rn->left != NULL)
                    que.push(rn->left);
                if (rn->right != NULL)
                    que.push(rn->right);

            }
            vector<int> base = smallAns;
            st.push(base);
            smallAns.clear();
        }
    }
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        if(root==NULL) return {};
        vector<vector<int>> ans;
        stack<vector<int>> st;
        levelOrder_M3(root,st);
        while(st.size()>0) {
            ans.push_back(st.top());
            st.pop();
        }
        return ans;
    }
};