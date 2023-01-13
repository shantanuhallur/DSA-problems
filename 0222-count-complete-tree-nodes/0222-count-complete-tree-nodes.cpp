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
      int getDepth(TreeNode* node) {
        int depth = 0;
        while(node->left) {
            node = node->left;
            ++depth;
        }
        return depth;
    }
    
      bool exists(TreeNode* node,int d, int idx) {
        int left = 0 , right = (int) pow(2,d) -1;
        
        for(int i=0;i<d;i++) {
            int mid= left + (right-left)/2;
            if(idx<=mid) {
                node = node->left;
                right = mid;
            }
            else{
                node = node->right;
                left = mid + 1;
            }
        }
        return node!=NULL;
    }
    
    int countNodes(TreeNode* root) {
        if(root == NULL) return 0;
        
        int d = getDepth(root);
        if(d == 0) return 1;
        
        int left = 1, right = (int) pow(2,d) -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(exists(root,d,mid)) left = mid+1;
            else right = mid-1;
            
        }
        
        return (int)pow(2,d)-1 + left;
    }
};