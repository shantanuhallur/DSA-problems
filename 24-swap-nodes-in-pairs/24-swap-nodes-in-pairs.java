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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)return head;
        
        ListNode dummy = new ListNode(-1);
        ListNode l1 = dummy;
        ListNode n1 = head;
        ListNode n2 = head.next;
        
        while(n2!=null){
            l1.next = n2;
            n2 = n2.next;
            l1.next.next = n1;
            l1 = n1;
            n1.next=null;
            n1 = n2;
            n2 = (n1==null)?null:n1.next;
        }
        if(n1!=null)l1.next=n1;
        return dummy.next;
    }
}