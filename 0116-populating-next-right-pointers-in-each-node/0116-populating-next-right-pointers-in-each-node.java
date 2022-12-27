/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public void connect_01(Node node) {
        //TRAVELS THE LEVEL ROW by ROw
        while(node.left!=null) {
            Node firstN = node.left;
            //Inner While loop to complete the level (nody by node)
            while(true) {
                node.left.next = node.right;
                
                if(node.next != null) node.right.next = node.next.left;
                else break;
                
                node = node.next;
            }
            
            node = firstN;
        }
    }
    public Node connect(Node root) {
        if(root == null) return null;
        connect_01(root);
        return root;
    }
}