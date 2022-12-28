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
    int widthOfBinaryTree(TreeNode* root) {
        queue<pair<TreeNode*,int>> que;
        que.push({root,0});
        int ans=0;
        while(que.size()!=0) {
            int startId = 0;
            int endId = 0;
            int size = que.size();
            for(int i=0;i<size;i++) {
                pair removeP = que.front(); que.pop();
                
                if(removeP.first->left) que.push({removeP.first->left,(long long)removeP.second*2 +1});
                
                if(removeP.first->right) que.push({removeP.first->right,(long long)removeP.second*2 +2});
                //start
                if(i==0) startId = removeP.second;
                if(i==size-1) endId = removeP.second;
            }
            ans = max(ans,endId-startId+1);
        }
        return ans;
    }
};