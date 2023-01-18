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
        if(node1 == null && node2 == null) return true; // both are null hence equal.
        if(node1 == null || node2 == null) return false; // only 1 node exists out of the 2.
        if(node1.val != node2.val) return false; // both nodes are present but dont have equal values
        
        //left and right recursive call
        boolean lEqual = areEqual(node1.left,node2.left);
        boolean rEqual = areEqual(node1.right,node2.right);
        
        return (lEqual && rEqual);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //Base Case
        if(root == null) return false;
        
        if(root.val == subRoot.val) {
            if(areEqual(root,subRoot)) return true;
        }
        
        //left and right recursive calls
        boolean lAns = isSubtree(root.left,subRoot);
        boolean rAns = isSubtree(root.right,subRoot);
        
        return (lAns || rAns);
    }
}