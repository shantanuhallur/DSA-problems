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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode l3 = dummy;
        int carry=0;
        while(l1!=null || l2!=null){
            int val1 = l1!=null?l1.val:0;
            int val2 = l2!=null?l2.val:0;
            int sum = val1+val2+carry;
            int digit = sum%10;
            carry = sum/10;
            ListNode node = new ListNode(digit);
            l3.next = node;
            l3 = l3.next;
            
            if(l1 != null) l1=l1.next;
            if(l2 != null) l2=l2.next;
        }
        
        if(carry>0){
            ListNode node = new ListNode(carry);
            l3.next = node;
            l3=node;
        }
        return dummy.next;
    }
}