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
    public Node getParentSucc(Node node) {
        if(node.parent == null) return null;
        
        if(node == node.parent.right) return getParentSucc(node.parent);
        
        return node.parent;
    }
    
    public Node getLeftMostChild(Node node) {
        while(node.left != null) node = node.left;
        return node;
    }
    public Node inorderSuccessor(Node node) {
        if(node == null) return null;
        
        if(node.right!=null) return getLeftMostChild(node.right);
        else return getParentSucc(node);
    }
}