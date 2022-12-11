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
    
    public TreeNode getTail(TreeNode node) {
        if(node==null) return null;
        
        TreeNode curr = node;
        while(curr.right != null) {
            curr = curr.right;
        }
        return curr;
    }
    
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        flatten(root.left);
        flatten(root.right);
        
        TreeNode tail = getTail(root.left);
        if(tail != null) {
            tail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
}