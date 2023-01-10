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
    void inOrderTraversal(Node* node) {
        //base case 
        if(!node) return;
        //left and right recursive call for DFS
        inOrderTraversal(node->left);
        //INORDER AREA ->>>>>>>>>
        //save first node
        if(!prev) first = node;
        //add links in between nodes
        if(prev) {
            prev->right = node;
            node->left = prev;
        }
        //save last node
        if(!node->right) last = node;
        //INORDER AREA ->>>>>>>>>
        //update prev
        prev = node;
        inOrderTraversal(node->right);
        
    }
    Node* treeToDoublyList(Node* root) {
        //edge case
        if(!root) return nullptr;
        inOrderTraversal(root);
        // complete 2 links of first and last nodes
        first->left = last;
        last->right = first;
        
        return first;
    }
};