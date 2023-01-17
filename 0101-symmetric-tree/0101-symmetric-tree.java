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
    public boolean getSymmetric(TreeNode fNode,TreeNode sNode) {
        //if both nodes dont exist in this pos we return true;
        if(fNode == null && sNode == null) return true;
        //if even one of them is null return false
        if(fNode == null || sNode ==null) return false;
        //if both nodes exist but with different values we return false
        if(fNode.val != sNode.val) return false;
        //check bottom nodes if symmetric or not with right position
        if(!getSymmetric(fNode.left,sNode.right)) return false;
        if(!getSymmetric(fNode.right,sNode.left)) return false;
        //else the treee is symmetric
        return true;
    }
    public boolean isSymmetric(TreeNode root) {
        //Base Case 
        if(root == null) return true;
        return getSymmetric(root.left,root.right);
    }
}