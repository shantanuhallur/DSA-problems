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
    int ancestor = -1;
    public void diff(TreeNode node,int max, int min) {
        if(node == null) return;
        
        max = Math.max(max, node.val);
        min = Math.min(min,node.val);
        
        ancestor = Math.max(ancestor,Math.abs(max-min));
        diff(node.left,max,min);
        diff(node.right,max,min);
        
    }
    public int maxAncestorDiff(TreeNode root) {
        diff(root,root.val,root.val);
        return ancestor;
    }
}