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
class BSTIterator {
public:
    stack<TreeNode*> st;
    void addAllLeftN(TreeNode* curr) {
        //Base Case
        if(curr==nullptr) return;
        //Add all the left nodes till we get null.
        while(curr != nullptr) {
            st.push(curr);
            curr = curr->left;
        }
        
    }
    BSTIterator(TreeNode* root) {
        //Constructor call -> all all left of root node
        addAllLeftN(root);
    }
    
    int next() {
        //Get the inorder node in curr removeN
        TreeNode* removeN = st.top(); st.pop();
        addAllLeftN(removeN->right);
        
        return removeN->val;
    }
    
    bool hasNext() {
        return st.size()!=0;
    }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */