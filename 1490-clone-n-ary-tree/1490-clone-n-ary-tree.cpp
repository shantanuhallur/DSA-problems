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
        
        Node* croot = new Node(root->val);
        int size = root->children.size();
        for(int i=0;i<size;i++) {
            if(root->children[i]) croot->children.push_back(cloneTree(root->children[i]));
            //else croot->children.push_back(nullptr);
        }
        return croot;
    }
};