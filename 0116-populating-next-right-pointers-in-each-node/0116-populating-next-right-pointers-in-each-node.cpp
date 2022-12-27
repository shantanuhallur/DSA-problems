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
        
        while(node->left) {
            Node* firstPtr = node->left;
            while(true) {
                node->left->next = node->right;
                
                if(node->next) node->right->next = node->next->left;
                else break;
                
                node = node->next;
            }
            node = firstPtr;
        }
    }
    
    Node* connect(Node* root) {
        if(!root) return {};
        connect_01(root);
        return root;
    }
};