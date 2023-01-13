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
    int pairC = 0;
    vector<int> getPairs(TreeNode* node, int d) {
        //Base Case
        if(!node) return {};
        //if leaf create and return distance 1
        if(!node->left && !node->right) return {1};
        //left and right recursive call for information
        vector<int> lAns = getPairs(node->left,d);
        vector<int> rAns = getPairs(node->right,d);
        //try to make pairs with all leaves if left and right
        for(int val1 : lAns) {
            for(int val2 : rAns) {
                //check if our pair is valid
                if(val1 + val2 <= d) pairC ++;
            }
        }
        int n = lAns.size(); int m = rAns.size();
        vector<int> myAns(n+m,0);
         //distance upate for leaves to return to parent node;
        int i = 0;
        for(int val : lAns) myAns[i++] = val+1;
        for(int val : rAns) myAns[i++] = val+1;
        //return this updated myAns to parent
        return myAns;
    }
        
    int countPairs(TreeNode* root, int distance) {
        getPairs(root,distance);
        return pairC;
    }
};