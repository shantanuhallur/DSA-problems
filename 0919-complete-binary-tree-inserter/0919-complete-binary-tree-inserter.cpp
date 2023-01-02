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
    TreeNode* dummyRoot;
    queue<TreeNode*> que;
    TreeNode* currPtr = nullptr;
    CBTInserter(TreeNode* root) {
        dummyRoot = root;
        //levelOrderTraversal
        que.push(root);
        
        while(true) {
            TreeNode* rn = que.front();
            currPtr = rn;
            //if left child doesnt not exist we have our first incomplete filled node
            if(rn->left) que.push(rn->left);
            else break;
            //if right child doesnt not exist we have our first incomplete filled node
            if(rn->right) que.push(rn->right);
            else break;
            
            que.pop();
        }
    }
    
    int insert(int val) {
        int returnVal = currPtr->val;
        //if left node if not filled of our node then add the new node to the left.
        if(!currPtr->left) {
            TreeNode* node = new TreeNode(val);
            currPtr->left = node;
            //add the usefull node in que
            que.push(currPtr->left);
        }
        //if my node is filled in left add the node in right and update my currPtr
        else{
            TreeNode* node = new TreeNode(val);
            currPtr->right = node;
            que.push(currPtr->right);
            que.pop();
            currPtr = que.front();
        }
        
        return returnVal;
    }
    
    TreeNode* get_root() {
        return dummyRoot;
    }
};

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter* obj = new CBTInserter(root);
 * int param_1 = obj->insert(val);
 * TreeNode* param_2 = obj->get_root();
 */