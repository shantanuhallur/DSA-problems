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
       
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode curr = temp;
        
        while(curr.next!=null && curr.next.next != null){
            ListNode fnode = curr.next;
            ListNode snode = curr.next.next;
            fnode.next = snode.next;
            curr.next = snode;
            curr.next.next = fnode;
            curr = curr.next.next;
        }
        return temp.next;
    }
}