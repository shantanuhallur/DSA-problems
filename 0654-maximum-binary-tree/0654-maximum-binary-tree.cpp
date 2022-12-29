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
    TreeNode* makeBST(vector<int>& nums,int st,int end) {
        if(st>end) return nullptr;
        int midIdx = -1;
        int max = -1;
        for(int i=st;i<=end;i++) {
            if(nums[i] > max) {
                midIdx = i;
                max = nums[i];
            }
        }
        
        TreeNode* root = new TreeNode(nums[midIdx]);
        
        root->left = makeBST(nums,st,midIdx-1);
        
        root->right = makeBST(nums,midIdx+1,end);
        
        return root;
    }
    
    TreeNode* constructMaximumBinaryTree(vector<int>& nums) {
        return makeBST(nums,0,nums.size()-1);
    }
};