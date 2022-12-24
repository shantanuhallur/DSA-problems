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
    void binaryTreePaths_01(TreeNode* node,string currPath, vector<string>& ans) {
        //Base Case 
        if(!node->left && !node->right) {
            currPath += to_string(node->val);
            ans.push_back(currPath);
            return;
        }
        
        //Updation of CurrPath
        currPath += to_string(node->val) + "->";
        
        //Left & Right Recursive Calls
       if(node->left) binaryTreePaths_01(node->left,currPath,ans);
       if(node->right) binaryTreePaths_01(node->right,currPath,ans);
    }
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> ans;
        binaryTreePaths_01(root,"",ans);
        return ans;
    }
};