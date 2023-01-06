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
        unordered_set<int> childrenSet;
        //loop over trees to add all the children of each node.
        for(auto* node : tree) {
            for(auto* child : node->children) {
                childrenSet.insert(child->val);
            }
        }
        //check which node in tree vector is not present in our childrenSet
        Node* root = nullptr;
        for(auto* node : tree) {
            if(childrenSet.find(node->val) == childrenSet.end()) root = node;
        }
        
        return root;
    }
};