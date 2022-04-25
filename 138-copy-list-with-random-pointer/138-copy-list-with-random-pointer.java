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
    public Node copyRandomList(Node head) {
         if(head==null)return head;
        
        HashMap<Node,Node> map = new HashMap<>();
        Node curr = head;
        Node dummy = new Node(-1);
        Node prev = dummy;
        
        while(curr!=null){
            Node node = new Node(curr.val);
            prev.next = node;
            map.put(curr,node);
            prev = prev.next;
            curr=curr.next;
        }
        
        dummy = dummy.next;
        Node c1 = head;
        
        
        while(c1!=null){
            Node copyNode = map.get(c1);
            copyNode.random = (map.get(c1.random))!=null?map.get(c1.random):null;
             
            c1 = c1.next;
            
            
        }
        
        return dummy;
        
//         HashMap<Node,Node> map = new HashMap<>();
//         Node curr = head;
//         Node nHead = new Node(-1);
//         Node prev = nHead;

//         while(curr!=null){
//             Node node = new Node(curr.val); 
//             prev.next = node;
//             map.put(curr,node);
//             prev= prev.next;
//             curr = curr.next;
//         }

//         nHead = nHead.next;
//         Node c1 = head;
//         Node c2 = nHead;

//         while(c1!=null){
//             c2.random = (map.get(c1.random)!=null ? map.get(c1.random) : null );
            
//             c1=c1.next;
//             c2=c2.next;

//         }

//         return nHead;
    }
}