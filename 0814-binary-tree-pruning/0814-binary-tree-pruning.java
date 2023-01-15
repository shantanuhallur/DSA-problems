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
    boolean containsOnes(TreeNode node) {
        if(node == null) return false;
        
        boolean leftC  = containsOnes(node.left);
        boolean rightC = containsOnes(node.right);
        
        if(!leftC) node.left = null;
        if(!rightC) node.right = null;
        
        return leftC || rightC || node.val == 1;
    }
    public TreeNode pruneTree(TreeNode root) {
        if(root==null) return null;
        containsOnes(root);
        return (root.left == null && root.right == null && root.val !=1) ? null : root;
    }
}