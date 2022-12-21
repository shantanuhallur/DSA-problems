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
    public int closestValue(TreeNode root, double target) {
        int val,closestN  = root.val;
        
        while(root != null) {
            val = root.val;
            closestN = Math.abs(val-target) < Math.abs(closestN-target) ? val : closestN;
            if(target < root.val) root = root.left;
            else root = root.right;
        }
        
        return closestN;
    }
}