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
        int width = 0;
        queue<pair<TreeNode*,int>> que;
        que.push({root,0});

        while(que.size()!=0) {
            int size = que.size();
            int start = 0;
            int end = 0;
            for(int i=0;i<size;i++) {
                pair removeP = que.front(); que.pop();
                
                if(removeP.first->left) que.push({removeP.first->left,(long long)removeP.second*2+1});
                
                if(removeP.first->right) que.push({removeP.first->right,(long long)removeP.second*2+2});
                
                //starting & ending 
                if(i == 0) start = removeP.second;
                if(i == size-1) end = removeP.second;
            }
            width = max(width,end-start+1);
        }
        return width;
    }
};