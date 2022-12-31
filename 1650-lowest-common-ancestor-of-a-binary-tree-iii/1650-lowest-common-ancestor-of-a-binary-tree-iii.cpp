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
        unordered_set<Node*> set;
        while(temp1!=nullptr){
            if(temp1 == p) return temp1;
            temp1 = temp1->parent;
            set.insert(temp1);
        }
        
        Node* temp2 = p;
        while(temp2!=nullptr) {
            if(temp2 == q || set.find(temp2) != set.end())return temp2;
            temp2 = temp2->parent;
        }
        return nullptr;
    }
};