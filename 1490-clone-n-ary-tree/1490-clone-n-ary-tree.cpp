/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
public:
    Node* cloneTree(Node* root) {
        if(!root) return nullptr;
        
        Node* cloneRoot = new Node(root->val);
        
        int size = root->children.size();
        //Clone every node in root's children and add it in cloneRoot's children.
        for(int i=0;i<size;i++) {
            if(root->children[i]) cloneRoot->children.push_back(cloneTree(root->children[i]));
        }
        
        return cloneRoot;
    }
};