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
    vector<int> preorder(Node* root) {
        vector<int> ans;
        if(root == nullptr) return ans;
        
        stack<Node*> st;
        st.push(root);
        
        while(st.size()!=0) {
              Node* rn = st.top(); st.pop();
            
            for(int i= rn->children.size()-1;i>=0;i--) {
                st.push(rn->children[i]);
            }
            ans.push_back(rn->val);
        }
        return ans;
    }
};