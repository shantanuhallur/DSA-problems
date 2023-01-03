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
    public Node connect(Node root) {
        //base case
        if(root==null) return null;
        
        LinkedList<Node> que = new LinkedList<>();
        //add root in que for BFS
        que.addLast(root);
        //start BFS/Level Order Traversal
        while(que.size()!=0) {
            //get size of que
            int size = que.size();
            for(int i=0;i<size;i++) {
                Node removeN = que.removeFirst();
                //if next node exists in que
                if(i!= size-1) {
                    removeN.next = que.peekFirst();
                }
                else{ // this is the last node in the level
                    removeN.next = null;
                }
                //set up next level in the que if exists
                if(removeN.left !=null) que.addLast(removeN.left);
                if(removeN.right !=null)que.addLast(removeN.right);
            }
        }
        return root;
    }
}