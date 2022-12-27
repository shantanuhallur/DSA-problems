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
[-1,#,0,1,#,2,3,4,5,#,6,7,8,9,#]};
*/

class Solution {
    public void connect_01(Node node) {
        while(node.left!=null) {
            Node firstPtr = node.left;
            while(true) {
                node.left.next = node.right;
                
               if(node.next!=null) node.right.next = node.next.left;
                else break;
                
                node = node.next;
            }
            
            node = firstPtr;
        }
    }
    public Node connect(Node root) {
        if(root == null) return null;
        connect_01(root);
        return root;
    }
}