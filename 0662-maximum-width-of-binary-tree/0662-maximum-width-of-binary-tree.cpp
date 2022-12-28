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
        //LEVEL ORDER TRAVERSAL
        while(que.size()!=0) {
            int startId = 0;
            int endId = 0;
            int size = que.size();
            for(int i=0;i<size;i++) {
                pair removeP = que.front(); que.pop();
                
                //add left and right children if exist of removeP of node
                if(removeP.first->left){
                    pair addPair = {removeP.first->left,(long long)removeP.second*2+1};
                    que.push(addPair);
                }
                
                if(removeP.first->right){
                    pair addPair = {removeP.first->right,(long long)removeP.second*2+2};
                    que.push(addPair);
                }
                //startId
                if(i == 0) startId = removeP.second;
                //endId
                if(i == size-1) endId = removeP.second;
            }
            //MAXIMIZE OUR width
            width = max(width,endId-startId+1);
        }
        return width;
    }
};