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
    int closestVal = -1;
    double minDiff = 1e10;
    public void closestValue_01(TreeNode node, double target) {
        if(Math.abs(node.val - target) < minDiff) {
            minDiff = Math.abs(node.val - target);
            closestVal = node.val;
        }
        
        if(node.left != null) {
            closestValue_01(node.left,target);
        }
        
        if(node.right != null) {
            closestValue_01(node.right,target);
        }
    }
    
    public int closestValue(TreeNode root, double target) {
        closestValue_01(root,target);
        return closestVal;
    }
}