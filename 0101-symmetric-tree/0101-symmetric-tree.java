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
    public boolean symmetric(TreeNode lnode,TreeNode rnode) {
        if(lnode==null && rnode==null) return true;
        if(lnode == null || rnode == null) return false;
        if(lnode.val != rnode.val) return false;
        
        if(!symmetric(lnode.left,rnode.right)) return false;
        if(!symmetric(lnode.right,rnode.left)) return false;
        
        return true;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return false;
        return symmetric(root.left,root.right);
    }
}