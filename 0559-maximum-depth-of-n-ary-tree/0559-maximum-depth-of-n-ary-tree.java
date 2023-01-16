/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int maxD = 1;
    public void findMaxDep(Node node,int currDepth) {
        // recursively traverse to every child of my current node 
        for(Node child : node.children) {
            findMaxDep(child,currDepth+1);
        }
        //update my maxDep if needed
        if(maxD<currDepth) {
            maxD = currDepth;
        }
    }
    public int maxDepth(Node root) {
        //Base case
        if(root==null) return 0;
        findMaxDep(root,1);
        return maxD;
    }
}