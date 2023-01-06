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
    void inorder(TreeNode* node, vector<int>& list) {
        //Base Case
        if(!node) return;
        
        //left and right recursive call
        inorder(node->left,list);
        //AREA OF INORDER ---->>>
        list.push_back(node->val);
        //AREA OF INORDER ---->>>
        inorder(node->right,list);
    }
    vector<int> getAllElements(TreeNode* root1, TreeNode* root2) {
        vector<int> list1;
        vector<int> list2;
        inorder(root1,list1);
        inorder(root2,list2);
        vector<int> ans;
        //merge the two sorted lists
        int i=0; int j=0;
        while(i<list1.size() && j<list2.size()) {
            if(list1[i]< list2[j]) {
                ans.push_back(list1[i++]);
            }
            else { //our list2 element is smaller add it in our ans
                ans.push_back(list2[j++]);
            }
        }
        //either one of the while list is already filled so now fill the remaining list
        while(i<list1.size()) ans.push_back(list1[i++]);
        while(j<list2.size()) ans.push_back(list2[j++]);
        
        //our merging is completed return ans list
        return ans;
    }
};