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
    public void maxAncestorDiff_01(TreeNode node,int maxE,int minE) {
        //Base Case
        if(node == null) return;
        //Update maxE , minE considering current node.
        maxE = Math.max(node.val,maxE);
        minE = Math.min(node.val,minE);
        //Maximize our ancestor Node
        ancestor = Math.max(ancestor,Math.abs(minE-maxE));
        //Recursive left and right calls
        maxAncestorDiff_01(node.left,maxE,minE);
        maxAncestorDiff_01(node.right,maxE,minE);
        
    }
    public int maxAncestorDiff(TreeNode root) {
        maxAncestorDiff_01(root,root.val,root.val);
        return ancestor;
    }
}