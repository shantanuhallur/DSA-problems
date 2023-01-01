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
    public void maxAncestorDiff_01(TreeNode node,int minE,int maxE) {
        if(node == null) return;
        
        minE = Math.min(node.val,minE);
        maxE = Math.max(node.val,maxE);
        
        ancestor = Math.max(ancestor,Math.abs(minE-maxE));
        
        maxAncestorDiff_01(node.left,minE,maxE);
        maxAncestorDiff_01(node.right,minE,maxE);
    }
    public int maxAncestorDiff(TreeNode root) {
        maxAncestorDiff_01(root,root.val,root.val);
        return ancestor;
    }
}