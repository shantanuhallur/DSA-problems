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
    void getList(TreeNode* node,vector<int>& list) {
        if(node==nullptr) return;
        
        getList(node->left,list);
        list.push_back(node->val);
        getList(node->right,list);
    }
    vector<int> getAllElements(TreeNode* root1, TreeNode* root2) {
        vector<int> list1,list2; 
        getList(root1,list1);
        getList(root2,list2);
        int i=0;int j=0;
        vector<int> ans;
        while(i<list1.size() && j< list2.size()){
            if(list1[i]<list2[j]) ans.push_back(list1[i++]);
            else ans.push_back(list2[j++]);
        }
        while(i<list1.size()) ans.push_back(list1[i++]);
        while(j<list2.size()) ans.push_back(list2[j++]);
        
        return ans;
    }
};