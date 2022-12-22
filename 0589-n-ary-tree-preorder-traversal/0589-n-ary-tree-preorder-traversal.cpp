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
        // Base Condition
        if(root == nullptr) return ans;
        //Addition of Root in new stack
        stack<Node*> st;
        st.push(root);
        // to iterate over all the children of my root and their own children in inorder.
        while(st.size()!=0) {
            Node* removeN = st.top(); st.pop();
            
            for(int i=removeN->children.size()-1 ; i>=0;i--) {
                st.push(removeN->children[i]);
            }
            //add the current removeN in answer.
            ans.push_back(removeN->val);
        }
        
        return ans;
    }
};