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
    int maxD =0;
    int getMaxDia(Node* node) {
        //Base case
        if(node->children.size()==0) return 0;
        
        int maxH1 = -1;
        int maxH2 = -1;
        
        for(Node* child : node->children) {
            int childH = getMaxDia(child);
            if(childH > maxH1) {
                maxH2 = maxH1;
                maxH1 = childH;
            }
            else if(childH > maxH2) {
                maxH2 = childH;
            }
            
            maxD = max(maxD,maxH1+maxH2+2);
        }
        return maxH1+1;
    }
    int diameter(Node* root) {
        getMaxDia(root);
        return maxD;
    }
};