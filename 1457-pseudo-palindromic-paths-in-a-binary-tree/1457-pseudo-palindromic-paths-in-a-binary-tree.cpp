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
    int paths = 0;
    void dfs(TreeNode* node, vector<int>& arr) {
        //Base case of leaf
        if(!node->left && !node->right) {
            arr[node->val]++;
            //check if the path is pseudo palindromic
            int oddFreqCount=0;
            for(int i=1;i<=9;i++) {
                if(arr[i]%2==1)oddFreqCount++;
            }
            //if less than or equal to 1 oddFreq count numbers
            if(oddFreqCount <=1) paths++;
            arr[node->val]--;
            return;
        }
        //increament the freq of current node
        arr[node->val]++;
        //left and right recursive call
        if(node->left) dfs(node->left,arr);
        if(node->right) dfs(node->right,arr);
        //backtracking step for decrementing the current node after depth is explored
        arr[node->val]--;
    }
    int pseudoPalindromicPaths (TreeNode* root) {
        vector<int> arr(10,0);
        dfs(root,arr);
        return paths;
    }
};