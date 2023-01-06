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
    Node* findRoot(vector<Node*> tree) {
        unordered_set<Node*> set;
        for(auto* node : tree) {
            for(auto* node : node->children) {
                set.insert(node);
            }
        }
        Node* root = nullptr;
        for(auto* node:tree) {
            if(set.find(node)==set.end()) root = node;
        }
        return root;
    }
};