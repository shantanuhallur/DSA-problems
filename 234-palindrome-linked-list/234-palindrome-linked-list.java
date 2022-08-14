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
    
     public ListNode midNode(ListNode head) {
            if(head == null || head.next==null)return head;
            
            ListNode slow = head ,  fast = head;
            
            while(fast.next!=null && fast.next.next!=null){
                fast = fast.next.next;
                slow = slow.next;
            }
            
            return slow;
        }
    
     public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode prev = null , curr = head;
        while(curr!=null){
            ListNode forward = curr.next;
            curr.next=prev;
            prev = curr;
            curr = forward;
        }
        return prev;
    }
    
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        
        ListNode mid = midNode(head), nHead = mid.next;
        mid.next=null;
        nHead = reverseList(nHead);
        
        ListNode c1 = head ,  c2 = nHead;
        boolean res = true;
        while(c2!=null){
            if(c1.val!=c2.val) 
            {
                res = false;
                break;
            }
            c1=c1.next;
            c2=c2.next;
        }
        nHead =  reverseList(nHead);
        mid.next = nHead;
        
        return res;
    }
}