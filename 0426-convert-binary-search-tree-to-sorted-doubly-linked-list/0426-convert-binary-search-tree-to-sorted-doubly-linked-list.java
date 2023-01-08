/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    Node first = null;
    Node last = null;
    Node prev = null;
    public void traverse(Node node) {
        if(node == null) return;
        
        traverse(node.left);
        if(prev == null) first = node;
        if(prev!=null) {
            prev.right = node;
            node.left = prev;
        }
        if(node.right ==null) last = node;
        prev = node;
        traverse(node.right);
    }
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        traverse(root);
        first.left = last;
        last.right = first;
        return first;
    }
}