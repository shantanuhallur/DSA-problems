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
    TreeNode* reverseOddLevels(TreeNode* root) {
        deque<TreeNode*>dque;
        dque.push_back(root);
        int level = 0;
        while(dque.size()!=0) {
            int size = dque.size();
            while(size-->0) {
                TreeNode* removeN = dque.front(); dque.pop_front();
                
                if(removeN->left) dque.push_back(removeN->left);
                if(removeN->right) dque.push_back(removeN->right);
            }
            level++;
            
            if(level%2 != 0){
                int arr[dque.size()];
                int i=0;
               for(auto it = dque.begin();it!=dque.end();it++){
                   TreeNode* node = *it;
                    arr[i++] = node->val;
                }
                i--;
                for(auto it = dque.begin();it!=dque.end();it++) {
                    TreeNode* node = *it;
                    node->val = arr[i--];
                }
            }
        }
        return root;
    }
};