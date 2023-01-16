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
    int maxH = 1;
    public void findMaxH(Node node,int ht) {
        for(Node child:node.children) {
            findMaxH(child,ht+1);
        }
         if(node.children.size() == 0) {
            if(ht>maxH) {
                maxH = ht;
            }
         }
    }
    public int maxDepth(Node root) {
        if(root==null) return 0;
        findMaxH(root,maxH);
        return maxH;
    }
}