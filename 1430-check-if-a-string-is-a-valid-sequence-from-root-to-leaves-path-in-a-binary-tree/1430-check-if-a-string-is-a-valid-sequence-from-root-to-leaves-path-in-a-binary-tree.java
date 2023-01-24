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
    public boolean isValidSequence(TreeNode node,int[] arr,int idx) {
        if(node==null || idx==arr.length) return false;
        if(arr[idx] != node.val) return false;
        if(node.left==null && node.right==null && idx==arr.length-1) return true;
        return isValidSequence(node.left,arr,idx+1) || isValidSequence(node.right,arr,idx+1);
    }
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return isValidSequence(root,arr,0);
    }
}