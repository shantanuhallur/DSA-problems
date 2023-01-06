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
    Node* lowestCommonAncestor(Node* p, Node * q) {
        Node* temp1 = q;
        unordered_set<int> set;
        //first parent path
        while(temp1) {
            set.insert(temp1->val);
            if(temp1 == p) return temp1;
            temp1 = temp1->parent;
        }
        //second parent path
        temp1 = p;
        while(temp1) {
            if(temp1 == q || set.find(temp1->val)!=set.end()) return temp1;
            temp1 = temp1->parent;
        }
        return nullptr;
    }
};