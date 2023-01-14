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
    
    public TreeNode buildBST(ArrayList<Integer> arr,int st,int end) {
        if(st>end) return null;
        
        int mid = st +(end-st)/2;
        TreeNode root = new TreeNode(arr.get(mid));
        root.left = buildBST(arr,st,mid-1);
        root.right = buildBST(arr,mid+1,end);
        
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode curr = head;
        while(curr!= null) {
            arr.add(curr.val);
            curr = curr.next;
        }
        
        return buildBST(arr,0,arr.size()-1);
    }
}