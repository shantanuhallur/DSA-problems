/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;

    Node() {}

    Node(int _val) {
        val = _val;
        left = NULL;
        right = NULL;
    }

    Node(int _val, Node* _left, Node* _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
public:
    Node* prev = nullptr;
    Node* first = nullptr;
    Node* last = nullptr;
    
    void traverse(Node* node) {
        if(!node) return;
        traverse(node->left);
        if(!prev) first = node;
        
        if(prev) {
            prev->right = node;
            node->left = prev;
        }
        if(!node->right) last = node;
        prev = node;
        traverse(node->right);
    }
    Node* treeToDoublyList(Node* root) {
        if(!root) return nullptr;
        traverse(root);
        first->left = last;
        last->right = first;
        return first;
    }
};