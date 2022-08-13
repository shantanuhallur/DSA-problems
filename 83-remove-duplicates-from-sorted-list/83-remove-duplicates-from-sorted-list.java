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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        ListNode ptr = head;
        while(ptr !=null){
            while(ptr.next != null && ptr.val == ptr.next.val){
                ptr = ptr.next;
            }
            tail.next = ptr;
            ptr = ptr.next;
            tail = tail.next;
        }
        return dummy.next;
    }
}