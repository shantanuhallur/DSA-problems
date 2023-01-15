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
    Node* findLeftMostNode(Node* node) {
        while(node->left) node = node->left;
        return node;
    }
    
    Node* findSuccInParent(Node* node) {
        //no parent means no node is greater or i am the root node hence return null
        if(!node->parent) return NULL;
        //check if current node is a right child of a parent if yes we need to recurse on our parent
        if(node->parent->right == node) return findSuccInParent(node->parent);
        //if not then our node is a left child of a parent node means our parent is the successor
        return node->parent;
    }
    Node* inorderSuccessor(Node* node) {
        if(!node) return NULL;
        //if potential answer to my nodes right exist
        if(node->right) return findLeftMostNode(node->right);
        //else it means that no node exists in my nodes right child hence answer is in my parents
        return findSuccInParent(node);
    }
};