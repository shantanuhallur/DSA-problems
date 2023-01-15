/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* parent;
};
*/

class Solution {
public:
    Node* getLeftMostChild(Node* node) {
        while(node->left) node = node->left;
        
        return node;
    }
    
    Node* getParSucc(Node* node) {
        if(node->parent == NULL) return NULL;
        
        if(node == node->parent->right) return getParSucc(node->parent);
        
        return node->parent;
    }
    Node* inorderSuccessor(Node* node) {
        if(!node) return NULL;
        
        if(node->right) return getLeftMostChild(node->right);
        
        return getParSucc(node);
    }
};