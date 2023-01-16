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
    int maxH = -1;
    void findMaxH(Node* node,int ht) {
        for(Node* child:node->children) {
            findMaxH(child,ht+1);
        }
        if(node->children.size()==0) {
            if(maxH<ht) maxH = ht;
        }
    }
    int maxDepth(Node* root) {
        if(!root) return 0;
        findMaxH(root,1);
        return maxH;
    }
};