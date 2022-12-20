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
     int evaluateTree_01(TreeNode* node) {
        //Leaf Node Base Case
         if(node->left == nullptr && node->right==nullptr) return node->val;
         int leftAns = 0;
         int rightAns = 0;
         int operation = 0;
         //Left Recursive Call
         if(node->left != nullptr){
             leftAns = evaluateTree_01(node->left);
         }
         //Right Recursive Call
          if(node->right != nullptr){
             rightAns = evaluateTree_01(node->right);
         }
         
         //PostOrder Operation
         if(node->val == 2) {
             operation = (leftAns | rightAns);
         }
         
        if(node->val == 3) {
             operation = (leftAns & rightAns);
         }
          
         return operation;
    }
    bool evaluateTree(TreeNode* root) {
      return evaluateTree_01(root) == 1 ? true : false;
    }
};