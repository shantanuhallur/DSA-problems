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
    
    private void addFirst(ListNode node){
        if(th==null) th = tt = node;    
        else{
            node.next = th;
            th = node;
        }
    } 
    
    private int length(ListNode head){
        if(head==null) return 0;
        
        ListNode curr=head;
        int length = 0;
        while(curr!=null){
           curr=curr.next;
            length++;
        }
        
        return length;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next==null || k==1) return head;
        ListNode ah=null , at=null;
        ListNode curr = head , forw = null;
        int len = length(head);
        while(len >= k){
            int tempK=k;
            while(tempK-- >0){
                forw = curr.next;
                curr.next=null;
                addFirst(curr);
                curr = forw;
            }
            if(ah==null){
                ah=th;
                at = tt;
            }
            else{
                at.next = th;
                at = tt;
            }
            th = tt = null;
            
            len-=k;
        }
        at.next = curr;
        
        return ah;
    }
}