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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildBST(ListNode head,ListNode tail) {
        ListNode mid = head;
        ListNode fast = head;
        if(head == tail) return null;
        
        while(fast!= tail && fast.next != tail) {
            fast = fast.next.next;
            mid = mid.next;
        }
        
        TreeNode root = new TreeNode(mid.val);
        root.left = buildBST(head,mid);
        root.right = buildBST(mid.next,tail);
        
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        return buildBST(head,null);
    }
}