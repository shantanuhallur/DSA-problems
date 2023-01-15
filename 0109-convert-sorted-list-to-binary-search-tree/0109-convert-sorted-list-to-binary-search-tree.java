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
    public TreeNode buildTree(ListNode head,ListNode tail) {
        //Base Case
        if(head == tail) return null;
        //find root node to be created by finding mid of LL
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=tail && fast.next!=tail) {
            slow = slow.next; //move slow with 1 step
            fast = fast.next.next; //move fast with 2 steps
        }
        
        TreeNode root = new TreeNode(slow.val);
        //left and right recursive calls
        root.left = buildTree(head,slow);
        root.right = buildTree(slow.next,tail);
        //return root of this build tree
        return root;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        return buildTree(head,null);
    }
}