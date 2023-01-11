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
    TreeNode* buildBST(vector<int>& nums,int st,int end) {
        //Base Case
        if(st>end) return NULL;
        //get idx of max element in range st->end in nums
        int idx = -1;
        int maxNo = -1;
        for(int i = st;i<=end;i++) {
            if(maxNo<nums[i]) {
                idx = i;
                maxNo = nums[i];
            }
        }
        //Create a root node
        TreeNode* root = new TreeNode(nums[idx]);
        //pass left and right recursive calls like step 2 and 3 in algorithm
        root->left = buildBST(nums,st,idx-1);
        root->right = buildBST(nums,idx+1,end);
        
        return root;
        
    }
    TreeNode* constructMaximumBinaryTree(vector<int>& nums) {
        return buildBST(nums,0,nums.size()-1);
    }
};