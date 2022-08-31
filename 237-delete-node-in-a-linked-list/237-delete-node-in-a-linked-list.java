/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
	// //Copy the data 
	// node.val = node.next.val;
	// //Exchage the reference that's all :-D
	// node.next = node.next.next;
        
        ListNode next = node.next;
        
        node.val = next.val;
        node.next = next.next;
    }
}