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
    public boolean areEqual(TreeNode node1,TreeNode node2) {
        if(node1==null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        if(node1.val != node2.val) return false;
        
        return areEqual(node1.left,node2.left) && areEqual(node1.right,node2.right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        
        if(root.val == subRoot.val) {
            if(areEqual(root,subRoot)) return true;
        }
        
        boolean lAns = isSubtree(root.left,subRoot);
        boolean rAns = isSubtree(root.right,subRoot);
        
        return lAns || rAns;
    }
}