/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode th = null , tt = null;
    
    private void addLast(ListNode node){
        if(th==null){
            th = tt = node;
        }
        else{
            tt.next = node;
            tt = node;
        }
    }
    
    public ListNode removeElements(ListNode head, int val) {
  
        ListNode curr = head;
        
        while(curr!=null){
            if(curr.val!= val){
                ListNode forw = curr.next;
                curr.next = null;
                addLast(curr);
                curr=forw;
            }
            else{
                curr=curr.next;
            }
        }
        
        return th;
    }
}