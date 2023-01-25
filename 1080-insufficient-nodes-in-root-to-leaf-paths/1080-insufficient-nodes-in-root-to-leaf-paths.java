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
    public TreeNode getTree(TreeNode node,int limit) {
        if(node == null) return null;
        if(node.left == null && node.right == null) return node.val<limit? null : node;
        
        node.left = getTree(node.left,limit-node.val);
        node.right = getTree(node.right,limit-node.val);
        
        return node.left == node.right ? null : node;
    }
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return getTree(root,limit);
    }
}