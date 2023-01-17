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
    
    
    
    
    
    
     //convert the answer in int[]
    TreeNode* prev = NULL;
    int maxFreq = -1;
    int nodeFreq = 1;
    
    void inOrder(TreeNode* node,vector<int>& ans) {
        //BaseCase
        if(!node) return;
        //left and right recursive calls
        inOrder(node->left,ans);
        if(prev) {
            // increase node freq because we have got a node with same value
            if(node->val == prev->val) {
                nodeFreq++;
            }
            else {// we have got a new value node set its freq to 1
                nodeFreq = 1;
            }
        }
        //there can be already element added with a previous maxFreq
        if(maxFreq<nodeFreq) {
            ans.clear();
            ans.push_back(node->val);
            maxFreq = nodeFreq;
        }
        else if(maxFreq == nodeFreq) {
            //there will be multiple answers
            ans.push_back(node->val);
        }
        
        prev = node;
        inOrder(node->right,ans);
        
    }
    
    vector<int> findMode(TreeNode* root) {
        vector<int> ans;
        inOrder(root,ans);
        return ans;
    }
};