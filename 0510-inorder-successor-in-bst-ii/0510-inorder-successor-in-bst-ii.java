/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node getParentSuccessor(Node node) {
        if(node == null || node.parent == null) return null;
        if(node.parent.right == node) return getParentSuccessor(node.parent);
        return node.parent;
    }
    
    public Node getLeftMost(Node node) {
        while(node.left!=null) node = node.left;
        return node;
    }
    public Node inorderSuccessor(Node node) {
        if(node == null) return null;
        
        if(node.right != null) return getLeftMost(node.right);
        return getParentSuccessor(node);
    }
}