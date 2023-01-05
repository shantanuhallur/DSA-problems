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
    TreeNode prev = null;
    public void inOrder(TreeNode node,int[] arr) {
        if(node == null) return;
        
        if(node.left!=null) inOrder(node.left,arr);
        arr[0]--;
        if(arr[0]==0 && prev==null) prev = node;
        
        if(node.right!=null) inOrder(node.right,arr);
    }
    public int kthSmallest(TreeNode root, int k) {
        int[] arr = new int[1];
        arr[0] = k;
        inOrder(root,arr);
        return prev.val;
    }
}