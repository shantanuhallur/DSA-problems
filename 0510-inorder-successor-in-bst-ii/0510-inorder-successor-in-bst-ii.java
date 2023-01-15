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
    public Node findLeftMostNode(Node node) {
        while(node.left != null) node = node.left;
        return node;
    }
    public Node findNodeinParent(Node node) {
        //no parent means no node is greater or i am the root node hence return null
        if(node.parent == null) return null;
        //check if current node is a right child of a parent if yes we need to recurse on our parent
        if(node.parent.right == node) return findNodeinParent(node.parent);
        //if not then our node is a left child of a parent node means our parent is the successor
        return node.parent;
    }
    public Node inorderSuccessor(Node node) {
        if(node == null) return null;
        //if potential answer to my nodes right exist
        if(node.right!=null) return findLeftMostNode(node.right);
        //else it means that no node exists in my nodes right child hence answer is in my parents
        return findNodeinParent(node);
    }
}