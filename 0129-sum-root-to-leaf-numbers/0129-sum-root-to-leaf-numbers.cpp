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
    int sum = 0;
    void getSum(TreeNode* node,int currNum) {
        //Base Case
        if(!node) return;
        //calculate maintained No
        int maintaintedNo = currNum * 10 + node->val;
        //if my node is a leaf it means that my path has ended we need to add Maintained No in sum
        if(!node->left && !node->right) {
            sum += maintaintedNo;
            return;
        }
        //left and right recursive call for traversing the whole tree
        getSum(node->left,maintaintedNo);
        getSum(node->right,maintaintedNo);
    }
    int sumNumbers(TreeNode* root) {
        getSum(root,0);
        return sum;
    }
};