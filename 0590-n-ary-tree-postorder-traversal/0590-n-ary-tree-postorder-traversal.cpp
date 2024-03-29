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
    vector<int> postorder(Node* root) {
        vector<int> ans;
        if(root == nullptr) return ans;
        
        stack<Node*> st;
        st.push(root);
        
        while(st.size()!=0) {
            Node* removeN = st.top(); st.pop();
            
            for(Node* child : removeN->children) {
                st.push(child);
            }
            
            ans.insert(ans.begin(),removeN->val);
        }
        
        return ans;
    }
};