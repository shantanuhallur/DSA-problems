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
    int sumRootToLeaf_01(TreeNode* node,int sum) {
        //If tree Doesnt exist.
        if(node == nullptr) return 0;
        
        //Calculate Sum
        sum = (2*sum) + node->val;
        //Leaf condition
        if(node->left == nullptr && node->right == nullptr) return sum;
        //Get decimal sumation of left and right Paths.
        int leftSum = sumRootToLeaf_01(node->left,sum);
        int rightSum = sumRootToLeaf_01(node->right,sum);
        
        int totalSum = leftSum + rightSum;
        
        return totalSum;
    }
    
    int sumRootToLeaf(TreeNode* root) {
        return sumRootToLeaf_01(root,0);
    }
};