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
    vector<vector<int>> levelOrder(Node* root) {
        //Edge Case
        if(!root) return {};
        
        vector<vector<int>> ans;
        queue<Node*> que;
        que.push(root);
        //level order traversal
        while(que.size()!=0) {
            //size levelAns
            int size = que.size();
            vector<int> levelAns;
            while(size-->0) {
                Node* removeN = que.front(); que.pop();
                //add all the children of this removeN
                for(Node* child : removeN->children) {
                    que.push(child);
                }
                
                levelAns.push_back(removeN->val);
            }
            ans.push_back(levelAns);
        }
        return ans;
    }
};