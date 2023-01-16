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
    int maxD = 1;
    void findMaxDepth(Node* node,int currDepth) {
        //recursively travel each child node and maximize maxD
        for(Node* child : node->children) {
            findMaxDepth(child,currDepth+1);
        }
        //maximize Depth
        if(maxD < currDepth) {
            maxD = currDepth;
        }
    }
    
    int maxDepth(Node* root) {
        //Base Case
        if(!root) return 0;
        findMaxDepth(root,1);
        return maxD;
    }
};