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
    Node prev = null;
    Node first = null;
    Node last = null;
    public void inorderTraversal(Node node) {
        //Base Case
        if(node == null) return;
        
        //left and right recursive call for DFS
        inorderTraversal(node.left);
        //INORDER AREA ->>>>>>>>>
        //save first node
        if(prev == null) first = node;
        //add links in between nodes
        if(prev != null) {
            prev.right = node;
            node.left = prev;
        }
        //save last node
        if(node.right == null) last = node;
        //update our prev node
        prev = node;
        //INORDER AREA ->>>>>>>>>
        inorderTraversal(node.right);
    }
    public Node treeToDoublyList(Node root) {
        //edge case
        if(root==null) return null;
        inorderTraversal(root);
        // complete 2 links of first and last nodes
        first.left = last;
        last.right = first;
        
        return first;
    }
}