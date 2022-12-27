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
    void connect_01(Node* node) {
        //Outer While loop for each level
        while(node->left) {
            //Capture starting Node of each Row
            Node* firstN = node->left;
            while(true) {
                node->left->next = node->right;
                
                if(node->next) node->right->next = node->next->left;
                else break;
                //increament node in the row till last node.
                node = node->next;
            }
            node = firstN;
        }
    }
    
    Node* connect(Node* root) {
        if(!root) return {};
        connect_01(root);
        return root;
    }
};