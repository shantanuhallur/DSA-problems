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
            int getMin(vector<int>& arr) {
        int min_ = arr[0];
        for(int ele : arr) {
            min_ = min(ele,min_);
        }
        return min_;
    }
    
    int ans = (int)1e8;
     vector<int> getMinMax(TreeNode* node) {
        if(node == nullptr) {
            vector<int> base = {(int)1e8,-(int)1e8};
            return base;
        }
            
        vector<int> leftMinMax =  getMinMax(node->left);
           
        vector<int> rightMinMax = getMinMax(node->right);
        
        //ans
         vector<int> arr = {ans,abs(leftMinMax[0]-node->val),abs(leftMinMax[1]-node->val),abs(rightMinMax[0]-                                      node->val),abs(rightMinMax[1]-node->val)};
        ans = getMin(arr);
        
        vector<int> myNodeMinMax = {(int)1e8,-(int)1e8};
        
        //min
        myNodeMinMax[0] = min(leftMinMax[0],min(node->val,rightMinMax[0]));
        //max
        myNodeMinMax[1] = max(leftMinMax[1],max(node->val,rightMinMax[1]));
        
        return myNodeMinMax; 
    }
    
    int getMinimumDifference(TreeNode* root) {
        vector<int> dummy = getMinMax(root);
        return ans;
    }
};