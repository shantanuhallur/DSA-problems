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
class CBTInserter {
public:
    TreeNode* currPtr = nullptr;
    queue<TreeNode*> que;
    TreeNode* rt;
    CBTInserter(TreeNode* root) {    
        rt = root;
        que.push(root);
        
        while(true) {
            TreeNode* rn = que.front();
            currPtr = rn;
            if(rn->left) que.push(rn->left);
            else break;
            if(rn->right) que.push(rn->right);
            else break;
            
            que.pop();
        }
    }
    
    int insert(int val) {
        int returnVal = currPtr->val;
        //add in left
        if(!currPtr->left) {
            TreeNode* node = new TreeNode(val);
            currPtr->left = node;
            que.push(node);
        }
        else{
            TreeNode* node = new TreeNode(val);
            currPtr->right = node;
            que.push(node);
            que.pop();
            currPtr = que.front();
        }
        return returnVal;
    }
    
    TreeNode* get_root() {
        return rt;
    }
};

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter* obj = new CBTInserter(root);
 * int param_1 = obj->insert(val);
 * TreeNode* param_2 = obj->get_root();
 */