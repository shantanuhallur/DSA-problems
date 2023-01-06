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
        unordered_set<int> set;
        
        Node* temp1=p;
        while(temp1!=nullptr) {
            if(temp1==q) return temp1;
            set.insert(temp1->val);
            temp1 = temp1->parent;
        }
        
        Node* temp2=q;
        while(temp2!=nullptr) {
            if(temp2==p || set.find(temp2->val)!=set.end())return temp2;
            temp2=temp2->parent;
        }
        return nullptr;
    }
};