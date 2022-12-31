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
class FindElements {
public:
    unordered_set<int> set;
    void recoverTree(TreeNode* node,int idx) {
        if(!node) return;
        
        if(node->val != idx) node->val = idx;
        set.insert(node->val);
        
        recoverTree(node->left,idx*2+1);
        recoverTree(node->right,idx*2+2);
    }
    FindElements(TreeNode* root) {
        recoverTree(root,0);
    }
    
    bool find(int target) {
        return set.find(target)!=set.end() ? true : false;
    }
};

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements* obj = new FindElements(root);
 * bool param_1 = obj->find(target);
 */