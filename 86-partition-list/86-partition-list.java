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
    public ListNode partition(ListNode head, int x) {
        ListNode sDum = new ListNode(-1);
        ListNode beDum = new ListNode(-1);
        
        ListNode hc,sc,bc;
        hc = head;
        sc=sDum;
        bc=beDum;
        
        while(hc!=null){
            if(hc.val<x){
                sc.next = hc;
                sc = sc.next;
                 hc=hc.next;
                sc.next=null;
            }
            else{
                bc.next = hc;
                bc = bc.next;
                 hc=hc.next;
                bc.next=null;
            }
        }
        sc.next = beDum.next;
        
        return sDum.next;
    }
}