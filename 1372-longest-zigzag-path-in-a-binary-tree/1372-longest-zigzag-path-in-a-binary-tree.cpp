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
    
    int longestZigZag_01(TreeNode* node,int path) {
        if(!node) return 0;
        
        //left and right recursive Call
        int leftLongestPath = longestZigZag_01(node->left,1);
        int rightLongestPath = longestZigZag_01(node->right,2);
        //i AM LEFT CHILD of my parent NODE
        if(path == 1) {
            longest = max(longest,rightLongestPath+1);
            return rightLongestPath+1;
        }
        //i AM RIGHT CHILD of my parent NODE
        else if(path == 2) {
            longest = max(longest,leftLongestPath+1);
            return leftLongestPath+1;
        }
        else return max(leftLongestPath,rightLongestPath);
    }
    int longestZigZag(TreeNode* root) {
        int ans = longestZigZag_01(root,0);
        return max(ans,longest);
    }
};