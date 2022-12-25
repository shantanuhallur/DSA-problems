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
        LinkedList<Node> que1 = new LinkedList<>();
        LinkedList<Node> que2 = new LinkedList<>();
        que1.addLast(node);
        
        while(que1.size()!=0) {
            int size = que1.size();
            while(size-->0) {
                Node rn = que1.pop();
                if(!que1.isEmpty()){
                    rn.next = que1.peekFirst();
                }
                else{
                    rn.next = null;
                }
                
                if(rn.left !=null) que2.addLast(rn.left);
                if(rn.right !=null) que2.addLast(rn.right);
            }
            que1 = que2;
            que2 = new LinkedList<>();
        }
    }
    public Node connect(Node root) {
        if(root == null) return null;
        connect_01(root);
        return root;
    }
}