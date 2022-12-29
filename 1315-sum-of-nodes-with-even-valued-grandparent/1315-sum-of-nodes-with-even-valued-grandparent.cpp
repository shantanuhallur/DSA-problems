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
    int sumEvenGrandparent_01(TreeNode* node) {
        //Base Case
        if(!node) return 0;
        //variables
        int mySum = 0;
        int leftChildrenSum = 0;
        int rightChildrenSum = 0;
        
        //recursive left and right calls
        leftChildrenSum = sumEvenGrandparent_01(node->left);
        rightChildrenSum = sumEvenGrandparent_01(node->right);
        
        //IF MY NODE iS EVEN
        if(node->val%2==0) {
            //add left children
            if(node->left && node->left->left) mySum += node->left->left->val;
            if(node->left && node->left->right) mySum += node->left->right->val;
            
            //add right children
            if(node->right && node->right->left) mySum += node->right->left->val;
            if(node->right && node->right->right) mySum += node->right->right->val;
            
        }
        //return total sumation of all the nodes grandchildren.
        return mySum + leftChildrenSum + rightChildrenSum;
    }
    
    int sumEvenGrandparent(TreeNode* root) {
        return sumEvenGrandparent_01(root);
    }
};