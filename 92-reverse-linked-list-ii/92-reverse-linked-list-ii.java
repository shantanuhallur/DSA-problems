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
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null||head.next==null|| left==right)return head;
       int idx = 1;
        ListNode prev = null , curr = head;
        
        while(curr!=null){
            while(idx>=left && idx<= right){
                ListNode forw=curr.next;
                curr.next = null;
                addFirst(curr);
                curr=forw;
                idx++;
            }
            if(idx>right){
                if(prev!=null){
                    prev.next = th;
                    tt.next = curr;
                    return head;
                }
                else{  
                    tt.next = curr;
                    return th;
                }
            }
            
            idx++;
            prev=curr;
            curr=curr.next;
        }
        
        return head;
        
    }

}