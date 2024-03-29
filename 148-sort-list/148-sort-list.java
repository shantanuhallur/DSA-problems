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
    public ListNode midNode(ListNode head){
        if(head==null||head.next==null)return head;
        
        ListNode s=head,f=head;
        
        while(f.next!=null&& f.next.next!=null){
            f=f.next.next;
            s=s.next;
        }
        
        return s;
    }
    
    public ListNode mergeTwo(ListNode l1,ListNode l2){
        if(l1==null || l1 ==null) return l1==null?l2:l1;
        
        ListNode dum = new ListNode(-1);
        
        ListNode prev = dum , c1=l1 , c2 = l2;
        
        while(c1!=null && c2!=null){
            if(c1.val<c2.val){
                prev.next = c1;
                c1=c1.next;
            }
            else{
                prev.next = c2;
                c2=c2.next;
            }
            
            prev=prev.next;
        }
        
        prev.next = c1==null?c2:c1;
        
        return dum.next;
        
    }
    
    
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)return head;
        
        
        ListNode mid= midNode(head);
        ListNode nH = mid.next;
        mid.next = null;
        
       return  mergeTwo(sortList( head),sortList(nH));
    }
}