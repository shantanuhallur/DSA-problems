/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    
    private void addNode(Node head){
        Node curr = head;
        while(curr != null){
            Node forw = curr.next;
            Node copyNode = new Node(curr.val);
            
            curr.next = copyNode;
            copyNode.next = forw;
            
            curr = curr.next.next;
        }
    }
    
    private void updateRandom(Node head){
       Node curr = head;
        
        while(curr != null){
            curr.next.random = curr.random==null?null:curr.random.next;
            
            curr = curr.next.next;
        } 
    }
    
    private Node reOrder(Node head){
        
        Node dummy = new Node(-1);
        Node curr = head , prev = dummy;
        
        while(curr!=null){
            prev.next = curr.next;
            curr.next = curr.next.next;
            
            prev = prev.next;
            curr=curr.next;
        }    
        
        return dummy.next;
    }
    
    public Node copyRandomList(Node head) {
        if(head==null)return head;
        
        
        addNode(head);
        updateRandom(head);
        return reOrder(head);
        
       
        
        
    }
}