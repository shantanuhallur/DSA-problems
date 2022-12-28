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
    int longest = -1;
    int longestZigZag_01(TreeNode* node,int dir) {
        if(!node) return 0;
        
        int leftPath = longestZigZag_01(node->left,1);
        int rightPath = longestZigZag_01(node->right,2);
        
        if(dir == 1) {
            if(rightPath+1>longest) longest = rightPath+1;
            return rightPath+1;
        }
        else if(dir == 2) {
            if(leftPath+1>longest) longest = leftPath+1;
            return leftPath+1;
        }
        else return max(leftPath,rightPath);
    }
    
    int longestZigZag(TreeNode* root) {
        int ans = longestZigZag_01(root,0);
        ans = max(longest,ans);
        return ans;
    }
};