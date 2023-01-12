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
    int getHeight(TreeNode* node) {
        if(node == NULL) return -1;
        
        int leftH = getHeight(node->left);
        int rightH = getHeight(node->right);
        
        return max(leftH,rightH)+1;
    }
    
    void fillVector(TreeNode* node, vector<vector<string>>& ans,int first,int last, int level) {
        if(!node) return;
        
        int mid = first+(last-first)/2;
        ans[level][mid] = to_string(node->val);
        
        fillVector(node->left,ans,first,mid-1,level+1);
        fillVector(node->right,ans,mid+1,last,level+1);
    }
    vector<vector<string>> printTree(TreeNode* root) {
        int height = getHeight(root);
        cout<<height;
        int row = height+1;
        int col = pow(2,height+1)-1;
        //fill with balnks
        vector<vector<string>> ans (row,vector<string>(col,""));
        
        int first = 0;
        int last = col-1;
        fillVector(root,ans,first,last,0);
            
        return ans;
    }
};