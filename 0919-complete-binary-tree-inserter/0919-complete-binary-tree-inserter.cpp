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
    TreeNode* currPtr = nullptr;
    queue<TreeNode*>que;
    CBTInserter(TreeNode* root) {
        dummyRoot = root;
        que.push(root);
        //level order to remove useless nodes
        while(true) {
            TreeNode* rn = que.front();
            currPtr = rn;
            //if left child exists
            if(rn->left) que.push(rn->left);
            else break;
            //if right child exists
            if(rn->right) que.push(rn->right);
            else break;
            //else this is a useless NODE
            que.pop(); 
        }
    }
    
    int insert(int val) {
        int returnVal = currPtr->val;
        //if currPtr node's left child doesnt exist
        if(!currPtr->left) {
            TreeNode* node = new TreeNode(val);
            currPtr->left = node;
            que.push(node);
        }
        else{ //if left child already exists
            TreeNode* node = new TreeNode(val);
            currPtr->right = node;
            que.push(node);
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