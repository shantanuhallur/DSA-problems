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
    void fillList(TreeNode* node,vector<int>& list) {
        if(node->left == nullptr && node->right == nullptr) {
            list.push_back(node->val);
        }
        
        //Left Recursive Call
        if(node->left != nullptr) {
            fillList(node->left,list);
        }
        
        //Right Recursive Call
        if(node->right != nullptr) {
            fillList(node->right,list);
        }
    }
    
    bool leafSimilar(TreeNode* root1, TreeNode* root2) {
        vector<int> list1,list2;
        //fill the Lists
        fillList(root1,list1);
        fillList(root2,list2);
        
        //check if the sizes of both lists are same if not return false;
        int list1Size = list1.size();
        int list2Size = list2.size();
        
        if(list1Size != list2Size) return false;
        //check if all the integers inside the lists are same at same indexes.
        while(--list1Size >=0) {
            //if not return false
            if(list1[list1Size] != list2[list1Size]) return false;
        }
        //else return true;
        return true;
    }
};