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
    int preIdx = 0;
    int postIdx = 0;
    TreeNode* constructFromPrePost(vector<int>& pre, vector<int>& post) {
        //Root Creation
        TreeNode* root = new TreeNode(pre[preIdx++]);
        //check if tree is completed if not call recursively R & L
        if(root->val != post[postIdx]) {
            root->left = constructFromPrePost(pre,post);
        }
        
        if(root->val != post[postIdx]) {
            root->right = constructFromPrePost(pre,post);
        }
        
        //if both ifs are false then tree is already constructed return root.
        postIdx++;
        return root;
    }
};