/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* next;

    Node() : val(0), left(NULL), right(NULL), next(NULL) {}

    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

    Node(int _val, Node* _left, Node* _right, Node* _next)
        : val(_val), left(_left), right(_right), next(_next) {}
};
*/

class Solution {
public:
    Node* connect(Node* root) {
        //Base Case
        if(!root) return nullptr;
        queue<Node*> que;
        que.push(root);
        //BFS/Level Order Traversal
        while(que.size()!=0) {
            int size = que.size();
            //inner for loop for getting last size-1th iteration
            for(int i=0;i<size;i++) {
                //get our first Node
                Node* removeN = que.front(); que.pop();
                //if not last iteration set next to que front
                if(i!=size-1) {
                    removeN->next = que.front();
                }
                else{ // we are at the last iteration attach null to next of removeN
                    removeN->next = nullptr;
                }
                
                //set up our next level of the que
                if(removeN->left) que.push(removeN->left);
                if(removeN->right) que.push(removeN->right);
            }
        }
        return root;
    }
};